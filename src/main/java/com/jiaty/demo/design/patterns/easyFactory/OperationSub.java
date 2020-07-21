package com.jiaty.demo.design.patterns.easyFactory;

/**
 * @program: Practice
 * @description: 减法
 * @author: Jiaty
 * @create: 2020-07-21 15:08
 **/

public class OperationSub extends Operation {

    @Override
    public double getResult() {
        return getNumberA() - getNumberB();
    }
}