package com.awesom.fund.web;

import com.awesom.fund.mapper.CompanyMapper;
import com.awesom.fund.mapper.FundMapper;
import com.awesom.fund.mapper.ManagerMapper;
import com.awesom.fund.modle.Company;
import com.awesom.fund.modle.Fund;
import com.awesom.fund.modle.Manager;
import com.awesom.fund.util.StringUtil;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.text.MessageFormat;
import java.util.List;
import java.util.Objects;

/**
 * @author yangdejun
 * @date 2020/09/22
 **/
@RestController
public class FoundController {

    @Autowired
    CompanyMapper companyMapper;

    @Autowired
    FundMapper fundMapper;

    @Autowired
    ManagerMapper managerMapper;

    OkHttpClient client = new OkHttpClient();

    @GetMapping(value = "/save/fund/all")
    void saveAllFund() throws IOException {
        List<Company> allCompany = companyMapper.findAllCompany();
        OkHttpClient client = new OkHttpClient();
        for (int j = 0; j < allCompany.size(); j++) {
            System.out.println(allCompany.get(j).getCompanyName() + " 旗下基金开始");
            String url = MessageFormat.format("https://www.howbuy.com/fund/company/{0}/fundlist/", allCompany.get(j).getCompanyCode());
            Request request = new Request.Builder()
                    .url(url)
                    .build();
            String html;
            try (Response response = client.newCall(request).execute()) {
                html = response.body().string();
                Document document = Jsoup.parseBodyFragment(html);
                Elements table = document.getElementsByClass("nTab20");
                Elements tbody = table.select("tbody");
                int i = 1;
                for (int m = 1; m < tbody.size(); m += 2) {
                    Elements tr = tbody.get(m).select("tr");
                    for (; i < tr.size(); i++) {
                        Elements tdc = tr.get(i).getElementsByClass("tdc");
                        Elements tdl = tr.get(i).getElementsByClass("tdl");
                        Elements tdr = tr.get(i).getElementsByClass("tdr");
                        Fund fund = new Fund();
                        fund.setFundCode(tdc.get(1).text());
                        fund.setFundName(tdl.get(0).text());
                        if (!"--".equals(tdr.get(0).text())) {
                            fund.setFundScale(Double.valueOf(tdr.get(0).text().replace(",", "")));
                        }

                        fund.setCompanyCode(allCompany.get(j).getCompanyCode());
                        fundMapper.insertOne(fund);
                        //编号
                        //String num = tdc.get(0).text();
                        //基金代码
                        //String code = tdc.get(1).text();
                        //基金名称
                        //String name = tdl.get(0).text();
                        //基金规模
                        //String scale = tdr.get(0).text();
                        //单位净值
                        //String worth = tdr.get(1).text();
                        //近三个月涨幅
                        //String increase = tdr.get(2).text();
                        //System.out.println(num + code + name + scale + worth + increase);
                    }
                    i = 1;
                }
            }
            System.out.println(allCompany.get(j).getCompanyName() + " 旗下基金结束");
        }
    }

    @GetMapping(value = "/update/fund/manager/code")
    void updateAllFundManagerCode() throws IOException {
        List<Manager> allManagerList = managerMapper.selectAll();
        OkHttpClient client = new OkHttpClient();
        for (int i = 0; i < allManagerList.size(); i++) {
            System.out.println(allManagerList.get(i).getFundManagerName() + "开始");
            String url = MessageFormat.format("https://www.howbuy.com/fund/manager/{0}", allManagerList.get(i).getFundManagerCode());
            Request request = new Request.Builder()
                    .url(url)
                    .build();
            String html;
            try (Response response = client.newCall(request).execute()) {
                html = response.body().string();
                Document document = Jsoup.parseBodyFragment(html);
                Element table = document.getElementById("nTab4_0");
                if (Objects.nonNull(table)) {
                    Elements tr = table.select("tr");
                    for (int j = 1; j < tr.size(); j++) {
                        String fundCode = StringUtil.extractNums(tr.get(j).getElementsByClass("fl").attr("href"));
                        Fund fund = new Fund();
                        fund.setFundCode(fundCode);
                        fund.setFundManagerCode(allManagerList.get(i).getFundManagerCode());
                        fundMapper.updateOne(fund);
                    }
                }
                System.out.println(allManagerList.get(i).getFundManagerName() + "结束");
            }

        }
    }
}
