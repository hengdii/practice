package com.jiaty.demo.test.date20200211;

import java.math.BigDecimal;

/**
 * @program: Practice
 * @description:
 * @author: Jiaty
 * @create: 2020-02-11 11:04
 **/

public class BigDeicmalTest {
    public static void main(String[] args) {
        BigDecimal a = new BigDecimal("10.0000000");

        System.out.println("1_" + a.stripTrailingZeros().toPlainString());

    }
}