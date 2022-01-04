package com.awesome.tips.threadpool;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.util.concurrent.*;

/**
 * 创建线程池的正确姿势
 * 当大于线程池中的线程 maximumPoolSize + capacity 之和时报 java.util.concurrent.RejectedExecutionException 但不至于 OOM error
 * @author yangdejun
 * @date 2020/09/03
 **/
public class ThreadPoolExecutorDemo {
    // 正确姿势 1
    private static ExecutorService es = new ThreadPoolExecutor(
            30,
            200,
            60L,
            TimeUnit.SECONDS,
            new ArrayBlockingQueue(100));

    /**
     * 正确姿势 2 guava
     * 通过上述方式创建线程时，不仅可以避免 OOM 的问题，还可以自定义线程名称，更加方便的出错的时候溯源
     */
    private static ThreadFactory namedThreadFactory = new ThreadFactoryBuilder().setNameFormat("demo-pool-%d").build();
    private static ExecutorService pool = new ThreadPoolExecutor(
            5,
            200,
            0L,
            TimeUnit.MILLISECONDS,
            new LinkedBlockingQueue<Runnable>(1024),
            namedThreadFactory,
            new ThreadPoolExecutor.AbortPolicy());

    public static void main(String[] args) {
        for (int i = 0; i < 300; i++) {
            try {
                es.execute(new SubThread());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            pool.execute(new SubThread());
        }
    }
}
