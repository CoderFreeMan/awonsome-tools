package com.awesome.tips.hashmap;

import org.springframework.util.StopWatch;

import java.util.HashMap;
import java.util.Map;

/**
 * @author yangdejun
 * @date 2020/09/02
 **/
public class HashMapTest {
    public static void main(String[] args) {
        int aHundredMillion = 10000000;
        Map<Integer, Integer> map = new HashMap<>();
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        for (int i = 0; i < aHundredMillion; i++) {
            map.put(i, i);
        }
        stopWatch.stop();
        System.out.println(stopWatch.getTotalTimeMillis());

        HashMap<Integer, Integer> map1 = new HashMap<>(aHundredMillion / 2);
        StopWatch stopWatch1 = new StopWatch();
        stopWatch1.start();
        for (int i = 0; i < aHundredMillion; i++) {
            map1.put(i, i);
        }
        stopWatch1.stop();
        System.out.println(stopWatch1.getTotalTimeMillis());

        HashMap<Integer, Integer> map2 = new HashMap<>(aHundredMillion);
        StopWatch stopWatch2 = new StopWatch();
        stopWatch2.start();
        for (int i = 0; i < aHundredMillion; i++) {
            map1.put(i, i);
        }
        stopWatch2.stop();
        System.out.println(stopWatch2.getTotalTimeMillis());
    }
}
