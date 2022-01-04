package com.awesome.tips.threadpool;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadExecutorUtil {
    public static final int THREAD_POOL_SIZE = 200;

    // @FIXME 此线程池最大可添加 Integer.MAX_VALUE 个未执行线程，这样有可能会导致 OOM
    // private static ExecutorService es = Executors.newFixedThreadPool(THREAD_POOL_SIZE);
    private static ExecutorService es = new ThreadPoolExecutor(
            30,
            200,
            60L,
            TimeUnit.SECONDS,
            new ArrayBlockingQueue(2000));

    public static void runTask(Runnable runnable) {
        long t = System.currentTimeMillis();
        es.execute(runnable);
        int count = 0;
        try {
            count = ((ThreadPoolExecutor)es).getActiveCount();
        } catch(Exception e) {
        }
        if(count>10) {
        }
    }

    public static void stopTask(){
        es.shutdown();
    }
}
