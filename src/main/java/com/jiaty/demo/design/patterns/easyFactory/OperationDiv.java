package com.jiaty.demo.design.patterns.easyFactory;

/**
 * @program: Practice
 * @description: 除法
 * @author: Jiaty
 * @create: 2020-07-23 10:41
 **/

public class OperationDiv extends Operation {

    @Override
    public double getResult() {
        if (getNumberB() == 0) {
            throw new RuntimeException("除数不能为0");
        }
        return getNumberA() / getNumberB();
    }
}