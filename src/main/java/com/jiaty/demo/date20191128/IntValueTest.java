package com.jiaty.demo.date20191128;

import java.math.BigDecimal;

/**
 * @program: Practice
 * @description: 小数的intvalue之后的值
 * @author: jiaty
 * @create: 2019-11-28 11:32
 **/

public class IntValueTest {


    public static void main(String[] args) {

        BigDecimal cash = BigDecimal.valueOf(0.3);

        Boolean flg = true;

        if (cash.intValue() >0){
            flg = false;
        }

        System.out.println(cash.intValue());
    }
}