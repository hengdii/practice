package com.jiaty.demo.test.numberTest;

import com.jiaty.demo.test.testModel.Person;

import java.math.BigDecimal;

/**
 * @program: Practice
 * @description: BigDecimal ==
 * @author: jiaty
 * @create: 2020-01-14 10:56
 **/

public class BigDecimalDemo {

    public static void main(String[] args) {

        Person person = new Person();
        //person.setPrice(BigDecimal.ZERO);
        //person.setPrice(BigDecimal.valueOf(0));
        person.setPrice(new BigDecimal(0));
        if (person.getPrice().compareTo(BigDecimal.ZERO) == 0){
            System.out.println(12321);
        }


    }


}