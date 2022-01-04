package com.awesome.tips;

/**
 * @author yangdejun
 * @date 2020/12/16
 **/
public class A {
    public static void main(String[] args) {
        float a = 1f;
        float b = 0.9f;
        float c = 0.1f;

        System.out.println(b + c);            // 1.0
        System.out.println((b + c) == a);     // true

        System.out.println(a - b);            // 0.100000024
        System.out.println((a -b) == c);      // false
    }
}
