package com.jiaty.demo.test.date20190730;

import java.lang.reflect.Field;

/**
 * @program: Practice
 * @description: 反射测试类
 * @author: jiaty
 * @create: 2019-07-30 16:19
 **/

public class CalculatorTest {

    /**
     * 这个面试题是考反射机制。给一个object类，只知道里面有一个属性值叫name，如何取得这个属性值
     *
     * @param args
     */

    public static void main(String[] args) {

        Calculator calculator = new Calculator();

        Class calculatorClass = calculator.getClass();

        Field[] fields = calculatorClass.getFields();
//        System.out.println(calculatorClass.getClassLoader());
        for (Field field : fields) {
            System.out.println(field.getName());
        }

    }


}