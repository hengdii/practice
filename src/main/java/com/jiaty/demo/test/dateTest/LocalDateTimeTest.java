package com.jiaty.demo.test.dateTest;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @program: Practice
 * @description:
 * @author: Jiaty
 * @create: 2020-06-10 15:25
 **/

public class LocalDateTimeTest {

    public static void main(String[] args) {

        System.out.println(LocalDateTime.now());


        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

        DateTimeFormatter dateTimeFormatter1 = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");

        String s3 = LocalDateTime.now().format(dateTimeFormatter1);
        System.out.println(s3);
    }


}