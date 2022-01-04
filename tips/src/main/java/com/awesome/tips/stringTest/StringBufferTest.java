package com.awesome.tips.stringTest;

/**
 * @author yangdejun
 * @date 2020/09/04
 **/
public class StringBufferTest {
    public static void main(String[] args) {
        // 线程安全
        StringBuffer wechat = new StringBuffer("Yang");
        String introduce = "good good study, day day up";
        StringBuffer yang = wechat.append(",").append(introduce);
        System.out.println(yang);
    }
}
