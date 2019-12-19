package com.jiaty.demo.test.date20190822;

import java.math.BigDecimal;

/**
 * @program: Practice
 * @description: 测试BigDecimal中setScale方法
 * @author: jiaty
 * @create: 2019-08-22 19:10
 **/

public class SetScaleDemo {

    public static void main(String[] args) {

        BigDecimal bigDecimal = new BigDecimal(123.053213);
        System.out.println(bigDecimal.setScale(2, BigDecimal.ROUND_HALF_UP));
    }

}