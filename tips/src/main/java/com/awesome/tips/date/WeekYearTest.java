package com.awesome.tips.date;

import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * @author yangdejun
 * @date 2020/09/01
 **/
public class WeekYearTest {

    public static void main(String[] args) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat sdf1 = new SimpleDateFormat("YYYY");
        System.out.println(sdf1.format(sdf.parse("2019-12-01")));
        System.out.println(sdf1.format(sdf.parse("2019-12-30")));
        System.out.println(sdf1.format(sdf.parse("2020-01-01")));
    }

}
