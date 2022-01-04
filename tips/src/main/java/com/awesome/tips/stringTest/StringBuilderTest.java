package com.awesome.tips.stringTest;

/**
 * @author yangdejun
 * @date 2020/09/04
 **/
public class StringBuilderTest {
    public static void main(String[] args) {
        // 线程不安全的
        StringBuilder wechat = new StringBuilder("yang");
        String introduce = "good good study, day day up";
        StringBuilder yang = wechat.append(",").append(introduce);
        System.out.println(yang);
    }
}
