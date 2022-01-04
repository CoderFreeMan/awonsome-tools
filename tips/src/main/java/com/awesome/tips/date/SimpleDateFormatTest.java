package com.awesome.tips.date;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.*;

/**
 * @author yangdejun
 * @date 2020/09/05
 **/
public class SimpleDateFormatTest {

    private static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    private static ThreadFactory namedThreadFactory = new ThreadFactoryBuilder().setNameFormat("demo-pool-%d").build();
    private static ExecutorService pool = new ThreadPoolExecutor(
            5,
            200,
            0L,
            TimeUnit.MILLISECONDS,
            new LinkedBlockingDeque<Runnable>(1024),
            SimpleDateFormatTest.namedThreadFactory,
            new ThreadPoolExecutor.AbortPolicy()
    );
    private static CountDownLatch countDownLatch = new CountDownLatch(100);

    public static void main(String[] args) throws ParseException, InterruptedException {
        // 创建一个 date 变量
        Date date = new Date();
        // 定义时间格式
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        // 将 date 变量转换为指定的格式
        String dateStr = sdf.format(date);
        System.out.println(dateStr);

        // 将指定格式转换为 date
        Date parse = sdf.parse(dateStr);
        System.out.println(parse);

        SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        sdf2.setTimeZone(TimeZone.getTimeZone("America/Los_Angeles"));
        System.out.println(sdf2.format(Calendar.getInstance().getTime()));

//        Set<String> dates = Collections.synchronizedSet(new HashSet<String>());
        List<String> dates = Collections.synchronizedList(new ArrayList<>());
        for (int i = 0; i < 100; i++) {
            Calendar calendar = Calendar.getInstance();
            int finalI = i;
            pool.execute(() -> {
                calendar.add(Calendar.DATE, finalI);
                String dateString = simpleDateFormat.format(calendar.getTime());
                dates.add(dateString);
                countDownLatch.countDown();
            });
        }
        countDownLatch.await();
        System.out.println(dates.size());
    }
}
