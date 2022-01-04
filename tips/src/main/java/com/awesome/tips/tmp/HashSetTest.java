package com.awesome.tips.tmp;

import java.util.HashSet;
import java.util.Set;

/**
 * @author yangdejun
 * @date 2020/09/15
 **/
public class HashSetTest {
    public static void main(String[] args) {
        Set s1 = new HashSet();
        s1.add("a");
        s1.add("a");
        s1.add("b");
        System.out.println(s1.size());
    }
}
