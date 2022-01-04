package com.awesome.tips.listTest;

import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.List;

/**
 * 谨慎使用 ArrayList 中的 subList 方法
 * 高度注意对源集合元素的增加和删除
 * subList 方法返回的是 ArrayList 的内部类 SubList，并不是一个新 ArrayList 实例，而是 ArrayList 的一个视图，对于 SubList 子列表的所有操作最终会反映到源列表上
 * 不能将 subList 方法返回的结果强制转成 ArrayList、LinkedList、Vector 等 List 的实现类，否则会报错：java.lang.ClassCastException: java.util.ArrayList$SubList cannot be cast to java.util.ArrayList
 *      SubList 并没有重新创建一个 List，而是直接引用了原有的 List，只是指定了一下他要使用的元素的范围而已
 *
 * 视图有什么问题：
 *      1. subList 中的某个元素的值改变时，原来的 List 中的元素的值也发生了改变
 *      2. 源 List 中的某个元素的值改变时，subList 中的元素的值也发生了改变
 *      3. subList 追加元素(结构性改变)，源 List 结果也追加了元素
 *      4. 源 List 追加元素(结构性改变)，subList 再使用时会发生异常：Exception in thread "main" java.util.ConcurrentModificationException
 *
 *
 * 总结：
 *      1. 对 父 (sourceList) 子 (subList)List 做 的 非 结 构 性 修 改（non-structural changes），都会影响到彼此。
 *      2. 对子 List 做结构性修改，操作同样会反映到父 List 上。
 *      3. 对父 List 做结构性修改，会抛出异常 ConcurrentModificationException。
 *
 * 如何创建新的 List：
 *      如果需要对 subList 做出修改，而又不想动源 List。那么可以创建 subList 的一个拷贝：
 *      subList = Lists.newArrayList(subList);
 *      list.stream.skip(strart).limit(end).collect(Collections.toList());
 * @author yangdejun
 * @date 2020/09/04
 **/
public class ArrayListTest {
    public static void main(String[] args) {
        List<String> names = new ArrayList<String>(8) {{
            add("Hollis");
            add("hollischuang");
            add("Yang");
        }};

        List subList = names.subList(0, 1);
        System.out.println(subList);
        subList.remove(0);
        System.out.println(subList);
        System.out.println(names);
        subList.add("Hollis");
        System.out.println(names);

        List<String> sourceList = new ArrayList<String>(){{
            add("A");
            add("B");
            add("C");
            add("L");
            add("L");
            add("I");
        }};
        List subList2 = sourceList.subList(2, 5);
        sourceList.add("666");

        System.out.println(sourceList);
        System.out.println(subList2);
    }
}
