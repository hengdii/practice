package com.jiaty.demo.test.date20200306;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @program: Practice
 * @description: DateTo String
 * @author: Jiaty
 * @create: 2020-03-06 11:46
 **/

public class DateToStringtest {


    public static void main(String[] args) {
        long time = System.currentTimeMillis();
        Date date = new Date();
        date.setTime(time);
        System.out.println(date.toString());


        Date currentTime = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateString = formatter.format(currentTime);
        System.out.println(dateString);


        String s = "2020-03-06 12:00:30";
//        System.out.println((Date)s);

    }
}