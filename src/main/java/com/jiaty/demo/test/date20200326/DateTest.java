package com.jiaty.demo.test.date20200326;

import javax.xml.crypto.Data;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * @program: Practice
 * @description:
 * @author: Jiaty
 * @create: 2020-03-26 14:40
 **/

public class DateTest {

    public static void main(String[] args) throws ParseException {

        String timeStr1=LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        String timeStr2= LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS"));
        System.out.println("当前时间为:"+timeStr1);
        System.out.println("当前时间为:"+timeStr2);


        System.out.println(BigDecimal.ZERO.intValue());
    }



}