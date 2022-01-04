package com.awesome.tips.stringTest;

/**
 * @author yangdejun
 * @date 2020/09/04
 **/
public class ConcatTest {
    public static void main(String[] args) {
        String wechat = "Yang";
        String introduce = "good good study, day day up";
        String yang = wechat.concat(",").concat(introduce);
        System.out.println(yang);
    }
}
