package com.jiaty.demo.design.patterns.easyFactory;

/**
 * @program: Practice
 * @description: 加法
 * @author: Jiaty
 * @create: 2020-07-21 15:07
 **/

public class OperationAdd extends Operation {


    @Override
    public double getResult() {
        return getNumberA() + getNumberB();
    }
}