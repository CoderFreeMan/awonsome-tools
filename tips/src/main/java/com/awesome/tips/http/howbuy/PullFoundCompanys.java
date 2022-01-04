package com.awesome.tips.http.howbuy;

import cn.hutool.http.HttpUtil;

/**
 * @author yangdejun
 * @date 2020/09/21
 **/
public class PullFoundCompanys {

    public String pullAllFoundCompany() {
        String foundCompanys = HttpUtil.get("https://www.howbuy.com/fund/company/ajax.htm");

        return null;
    }
}
