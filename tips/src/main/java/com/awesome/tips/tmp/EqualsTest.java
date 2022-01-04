package com.awesome.tips.tmp;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yangdejun
 * @date 2020/09/14
 **/
public class EqualsTest {
    public static void main(String[] args) {
        int a = 2;
        int b = 2;
        int c = 3;

        List l1 = new ArrayList();
        List l2 = new ArrayList();

        A a1 = new A();
        A a2 = new A();

        // true
        System.out.println(a == b);
        //false
        System.out.println(a == c);
        // false
        System.out.println(l1 == l2);
        // true
        System.out.println(l1.equals(l2));
        // false
        System.out.println(a1.equals(a2));
        // false
        System.out.println(a1 == a2);

    }
}

class A {

}