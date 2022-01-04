package com.awesome.tips.hashmap;

import com.google.common.collect.Maps;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * @author yangdejun
 * @date 2020/09/02
 **/
public class HashMapCapacityTest {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, NoSuchFieldException {
        Map<String, String> map = new HashMap<>(5);
        Class<?> mapType = map.getClass();
        Method capacity = mapType.getDeclaredMethod("capacity");
//        Field size = mapType.getDeclaredField("size");
        capacity.setAccessible(true);
        for (int i = 0; i < 10; i++) {
            map.put(String.valueOf(i), String.valueOf(i));
            System.out.println("elements counter : " + i + " -> capacity : " + capacity.invoke(map));
        }

        // guava
        HashMap<String, String> objectObjectHashMap = Maps.newHashMapWithExpectedSize(5);
    }
}
