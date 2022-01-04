package com.awesome.tips.Inherit;

/**
 * 发生在同一个类中，方法名必须相同，参数类型不同、个数不同、顺序不同，方法返回值和访问修饰符可以不同。
 * @author yangdejun
 * @date 2020/12/18
 **/
public class InheritTest {
    private Integer id;
    private String name;
    private Integer age;
    private Double salary;

    public InheritTest() {
    }

    public InheritTest(int id) {
    }

    public InheritTest(String name) {
    }

    public InheritTest(int id, int age) {
    }

    public InheritTest(int id, String name) {
    }

    public InheritTest(String name, int id) {
    }

    private InheritTest(double salary) {
    }

}
