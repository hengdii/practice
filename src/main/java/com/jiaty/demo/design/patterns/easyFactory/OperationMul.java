package com.jiaty.demo.design.patterns.easyFactory;

/**
 * @program: Practice
 * @description: 乘法
 * @author: Jiaty
 * @create: 2020-07-23 10:39
 **/

public class OperationMul extends Operation{

    @Override
    public double getResult() {
        return getNumberA() * getNumberB();
    }

}