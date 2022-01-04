package com.awesom.fund.howbuy;

import com.alibaba.fastjson.JSONObject;
import com.awesom.fund.entity.HowBuyCompanyEntity;
import com.awesom.fund.mapper.CompanyMapper;
import com.awesom.fund.modle.Company;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

/**
 * @author yangdejun
 * @date 2020/09/21
 **/
@RestController
public class FundCompany {
    @Autowired
    private CompanyMapper companyMapper;
    private static final String URL = "https://www.howbuy.com/fund/company/ajax.htm";
    OkHttpClient client = new OkHttpClient();
    @GetMapping(value = "/pull")
    List<HowBuyCompanyEntity> pullAllCompanyList() throws IOException {
        Request request = new Request.Builder()
                .url(URL)
                .build();
        List<HowBuyCompanyEntity> companies = null;
        try (Response response = client.newCall(request).execute()) {
            String companyListString = response.body().string();
            JSONObject jsonObject = JSONObject.parseObject(companyListString);
            String list = jsonObject.get("list").toString();
            companies = JSONObject.parseArray(list, HowBuyCompanyEntity.class);
        }
        for (int i = 0; i < companies.size(); i++) {
            Company company = new Company();
            company.setCompanyCode(companies.get(i).getJgdm());
            company.setCompanyName(companies.get(i).getJgjc());
            company.setEstablished(companies.get(i).getClrq());
            company.setFundTotal(companies.get(i).getJjsl());
            company.setFundManagerTotal(companies.get(i).getJjjlsl());
            company.setFundScale(companies.get(i).getJjzcjz());
            company.setOverallRating(companies.get(i).getJjdm());
            companyMapper.insertCompany(company);
        }
        return companies;
    }
}
