package com.jiaty.demo.test.dateTest;

import org.apache.commons.lang3.time.*;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @program: Practice
 * @description: DateTo String
 * @author: Jiaty
 * @create: 2020-03-06 11:46
 **/

public class DateToStringtest {


    public static void main(String[] args) throws ParseException {
//        long time = System.currentTimeMillis();
//        Date date = new Date();
//        date.setTime(time);
//        System.out.println(date.toString());
//
//
//        Date currentTime = new Date();
//        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        String dateString = formatter.format(currentTime);
//        System.out.println(dateString);


        String s = "2020-12-30T16:00:00.000Z";

        DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX");
        Date parse = df.parse(s);
        System.out.println(parse);
    }
}