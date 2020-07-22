package com.jiaty.demo.test.numberTest;

import java.math.BigDecimal;

/**
 * @program: practice
 * @description: intvalue
 * @author: jiaty
 * @create: 2019-12-24 17:43
 **/

public class IntValueTest {


    public static void main(String[] args) {

        Long s = new Long((long) 2.95);
        System.out.println();



        BigDecimal cash = BigDecimal.valueOf(0.3);

        Boolean flg = true;

        if (cash.intValue() > 0) {
            flg = false;
        }

        System.out.println(cash.intValue());

//        System.out.println(1/2);
//        System.out.println(2/2);
//        System.out.println(3/2);
//        System.out.println(4/2);

    }
}