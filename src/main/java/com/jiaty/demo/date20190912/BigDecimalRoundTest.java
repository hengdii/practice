package com.jiaty.demo.date20190912;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * @program: Practice
 * @description: 测试银行家算法
 * @author: jiaty
 * @create: 2019-09-12 11:34
 **/

public class BigDecimalRoundTest {

    public static void main(String[] args) {
        BigDecimal d = new BigDecimal("888888");
        BigDecimal r = new BigDecimal("0.001875");
        //银行家舍入算法4999.995
        BigDecimal i = d.multiply(r).multiply(new BigDecimal("3")).setScale(2, RoundingMode.HALF_EVEN);
        System.out.println(i);

    }
}