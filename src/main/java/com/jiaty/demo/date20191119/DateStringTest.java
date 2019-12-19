package com.jiaty.demo.date20191119;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @program: Practice
 * @description: Date和String的相互转化
 * @author: jiaty
 * @create: 2019-11-19 16:07
 **/

public class DateStringTest {

    public static void main(String[] args) throws ParseException {

        String str = "04/09/2019 14:04:13";

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

        Date date = simpleDateFormat.parse(str);

        System.out.println(date.toString());


    }


}