package com.awesome.tips.threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author yangdejun
 * @date 2020/09/03
 **/
public class ExecutorsDemo {
    // newFixedThreadPool 和 newSingleThreadExecutor
    // 最大可添加 Integer.MAX_VALUE 个未执行线程，这样有可能会导致 OOM
    private static ExecutorService executor = Executors.newFixedThreadPool(15);
    private static ExecutorService executor2 = Executors.newSingleThreadExecutor();

    // newCachedThreadPool 和  newScheduledThreadPool 最多可以创建 Integer.MAX_VALUE 个线程，可能会导致 OOM
    private static ExecutorService cacheThreadPool = Executors.newCachedThreadPool();
    private static ExecutorService schedulThreadPool = Executors.newScheduledThreadPool(5);
    public static void main(String[] args) {
        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            System.out.println("main");
            executor.execute(new SubThread());
        }
    }
}

class SubThread implements Runnable {
    @Override
    public void run() {
        try {
            Thread.sleep(5000);
            System.out.println("subThread");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
