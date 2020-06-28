package com.jiaty.demo.test.numberTest;

import java.math.BigDecimal;

/**
 * @program: Practice
 * @description:
 * @author: Jiaty
 * @create: 2020-06-23 14:56
 **/

public class BigDecimalDivde {

    public static void main(String[] args) {

        BigDecimal zero = BigDecimal.ZERO;

        System.out.println(zero.divide(BigDecimal.TEN,2,BigDecimal.ROUND_HALF_UP));

        BigDecimal ten = BigDecimal.ZERO;

        System.out.println(BigDecimal.ZERO.compareTo(ten) < 0);


    }
}