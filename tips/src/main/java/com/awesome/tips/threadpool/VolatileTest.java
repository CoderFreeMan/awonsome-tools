package com.awesome.tips.threadpool;

/**
 * @author yangdejun
 * @date 2020/12/25
 **/
public class VolatileTest {

    private static volatile int i = 0;

    public static void main(String[] args) throws InterruptedException {
        new Thread(() -> {
            for (int j = 0; j < 100; j++) {
                i += 1;
            }
            System.out.println("t1 -> " + i);
        }, "t1").start();

        new Thread(() -> {
            for (int j = 0; j < 100; j++) {
                i += 1;
            }
            System.out.println("t2 -> " + i);
        }, "t2").start();

        Thread.sleep(3000);
        System.out.println(i);
    }
}
