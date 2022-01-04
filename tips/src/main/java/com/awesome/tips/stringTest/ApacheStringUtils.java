package com.awesome.tips.stringTest;

import org.apache.commons.lang3.StringUtils;

/**
 * @author yangdejun
 * @date 2020/09/04
 **/
public class ApacheStringUtils {
    public static void main(String[] args) {
        String wechat = "Yang";
        String introduce = "hahaha";
        String yang = StringUtils.join(wechat, ",", introduce);
        System.out.println(yang);
    }
}
