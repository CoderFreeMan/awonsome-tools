package com.awesome.tips.ternaryOperator;

import java.util.HashMap;
import java.util.Map;

/**
 * @author yangdejun
 * @date 2020/09/01
 **/
public class TernaryOperator {
    public static void main(String[] args) {
        Map<String,Boolean> map = new HashMap<String, Boolean>();
        // @TODO verify
        Boolean b = (map!=null ? map.get("test") : false);
        Boolean c = (map!=null ? map.get("test") : Boolean.FALSE);
        System.out.println(b);
        System.out.println(c);
    }
}
