package com.awesom.fund.web;

import com.awesom.fund.mapper.CompanyMapper;
import com.awesom.fund.mapper.ManagerMapper;
import com.awesom.fund.modle.Company;
import com.awesom.fund.modle.Manager;
import com.awesom.fund.util.StringUtil;
import com.google.common.collect.Lists;
import okhttp3.OkHttp;
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

/**
 * @author yangdejun
 * @date 2020/09/22
 **/
@RestController
public class ManagerController {

//    private static final String URL = "https://www.howbuy.com/fund/company/80041198/managerlist";

    @Autowired
    ManagerMapper managerMapper;

    @Autowired
    CompanyMapper companyMapper;

    OkHttpClient client = new OkHttpClient();

    @GetMapping(value = "/save/manager/all")
    void saveAllManager() throws IOException {
        List<Company> allCompany = companyMapper.findAllCompany();
        for (int j = 0; j < allCompany.size(); j++) {
            System.out.println(allCompany.get(j).getCompanyName() + "开始");
            String url = MessageFormat.format("https://www.howbuy.com/fund/company/{0}/managerlist", allCompany.get(j).getCompanyCode());
            Request request = new Request.Builder()
                    .url(url)
                    .build();
            String html;
            try (Response response = client.newCall(request).execute()) {
                html = response.body().string();
            }
            if (html.length() > 0) {
                Document document = Jsoup.parseBodyFragment(html);
                Elements table = document.getElementsByClass("manager_list_con");
                if (table.size() > 0) {
                    Element tabel1 = table.get(0);
                    Elements tr = tabel1.getElementsByTag("tr");
                    for (int i = 1; i < tr.size(); i++) {
                        Manager manager = new Manager();
                        // 第 i 行数据
                        Element element = tr.get(i);
                        manager.setFundManagerCode(StringUtil.extractNums(element.getElementsByClass("tdl").select("a").attr("href")));
                        manager.setFundManagerName(element.getElementsByClass("tdl").text());
                        manager.setAppointmentDate(element.getElementsByClass("tdr").get(0).text());
                        manager.setAppointmentDays(Integer.valueOf(formatDay(StringUtil.extractSplitNums(element.getElementsByClass("tdr").get(1).text()))));
                        manager.setWorkingDays(Integer.valueOf(formatDay(StringUtil.extractSplitNums(element.getElementsByClass("tdr").get(1).text()))));
                        manager.setManagerFundNum(Integer.valueOf(element.getElementsByClass("tdr").get(3).text()));
                        manager.setCompanyCode(allCompany.get(j).getCompanyCode());
                        managerMapper.insertOneManager(manager);
                    }
                    System.out.println(allCompany.get(j).getCompanyName() + "结束");
                }

            }
        }


    }

    /*@GetMapping(value = "/save/manage1")
    void saveCompanyManager() throws IOException {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url(URL)
                .build();
        String html;
        try (Response response = client.newCall(request).execute()) {
            html = response.body().string();
        }

        Document document = Jsoup.parseBodyFragment(html);
        Elements table = document.getElementsByClass("manager_list_con");
        Element tabel1 = table.get(0);
        Elements tr = tabel1.getElementsByTag("tr");

        for (int i = 1; i < tr.size(); i++) {
            Manager manager = new Manager();
            // 第 i 行数据
            Element element = tr.get(i);
            manager.setFundManagerCode(StringUtil.extractNums(element.getElementsByClass("tdl").select("a").attr("href")));
            manager.setFundManagerName(element.getElementsByClass("tdl").text());
            manager.setAppointmentDate(element.getElementsByClass("tdr").get(0).text());
            manager.setAppointmentDays(Integer.valueOf(formatDay(StringUtil.extractSplitNums(element.getElementsByClass("tdr").get(1).text()))));
            manager.setWorkingDays(Integer.valueOf(formatDay(StringUtil.extractSplitNums(element.getElementsByClass("tdr").get(1).text()))));
            manager.setManagerFundNum(Integer.valueOf(element.getElementsByClass("tdr").get(3).text()));
            managerMapper.insertOneManager(manager);
        }
    }*/

    private static String formatDay(List<String> var) {
        if (var.size() == 1) {
            return var.get(0);
        }
        if (var.size() == 2) {
            return String.valueOf(Integer.valueOf(var.get(0)) * 365 + Integer.valueOf(var.get(1)));
        }
        return null;
    }
}
