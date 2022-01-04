package com.awesome.tips.threadpool;

import java.util.Locale;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @author yangdejun
 * @date 2020/09/10
 **/
public class ThreadFactoryBuilder {
    // 线程命名格式
    private String nameFormat = null;
    // 是否为守护线程
    private Boolean daemon = null;
    // 设置 ThreadFactory 创建的线程的优先级
    private Integer priority = null;
    //
    private Thread.UncaughtExceptionHandler uncaughtExceptionHandler = null;
    //
    private ThreadFactory backingThreadFactory = null;

    public ThreadFactoryBuilder() {
    }

    /**
     * 设置创建 ThreadFactory 创建的线程命名格式
     *
     * @param nameFormat
     * @return
     */
    public ThreadFactoryBuilder setNameFormat(String nameFormat) {
        String unused = format(nameFormat, 0);
        this.nameFormat = nameFormat;
        return this;
    }

    /**
     * 是否将 ThreadFactory 创建的新线程设置为守护线程
     *
     * @param daemon
     * @return
     */
    public ThreadFactoryBuilder setDaemon(boolean daemon) {
        this.daemon = daemon;
        return this;
    }

    /**
     * 设置使用此 ThreadFactory 创建的线程的优先级
     *
     * @param priority
     * @return
     */
    public ThreadFactoryBuilder setPriority(int priority) {
        //@TODO check argument， Thread.MIN_PRIORITY and Thread.MAX_PRIORITY
        // fail-fast

        this.priority = priority;
        return this;
    }

    /**
     * 为使用此 ThreadFactory 创建的新线程设置{@link Thread.UncaughtExceptionHandler}
     *
     * @param uncaughtExceptionHandler
     * @return
     */
    public ThreadFactoryBuilder setUncaughtExceptionHandler(Thread.UncaughtExceptionHandler uncaughtExceptionHandler) {
        // @TODO NPE check
        return this;
    }

    /**
     * 为使用此 ThreadFactory 创建的新线程设置 backing
     *
     * @param backingThreadFactory
     * @return
     */
    public ThreadFactoryBuilder setThreadFactory(ThreadFactory backingThreadFactory) {
        // @TODO NEP check
        return this;
    }

    /**
     * 构建一个新的 ThreadFactory
     *
     * @return
     */
    public ThreadFactory build() {
        return doBuild(this);
    }

    /**
     * 不能匿名创建
     *
     * @param builder
     * @return
     */
    private static ThreadFactory doBuild(ThreadFactoryBuilder builder) {
        final String nameFormat = builder.nameFormat;
        final Boolean daemon = builder.daemon;
        final Integer priority = builder.priority;
        final Thread.UncaughtExceptionHandler uncaughtExceptionHandler = builder.uncaughtExceptionHandler;
        final ThreadFactory backingThreadFactory =
                (builder.backingThreadFactory != null)
                        ? builder.backingThreadFactory
                        : Executors.defaultThreadFactory();
        final AtomicLong count = (nameFormat != null) ? new AtomicLong(0) : null;
        return new ThreadFactory() {
            @Override
            public Thread newThread(Runnable runnable) {
                Thread thread = backingThreadFactory.newThread(runnable);
                if (nameFormat != null) {
                    thread.setName(format((nameFormat), count.getAndIncrement()));
                }
                if (daemon != null) {
                    thread.setDaemon(daemon);
                }
                if (priority != null) {
                    thread.setPriority(priority);
                }
                if (uncaughtExceptionHandler != null) {
                    thread.setUncaughtExceptionHandler(uncaughtExceptionHandler);
                }
                return thread;
            }
        };
    }

    private static String format(String format, Object... args) {
        return String.format(Locale.ROOT, format, args);
    }
}
