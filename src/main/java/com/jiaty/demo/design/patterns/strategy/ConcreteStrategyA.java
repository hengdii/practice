package com.jiaty.demo.design.patterns.strategy;

/**
 * @program: Practice
 * @description: 封装算法的实现
 * @author: Jiaty
 * @create: 2020-07-23 11:27
 **/

public class ConcreteStrategyA extends Strategy {
    @Override
    public void arithmInterface() {
        System.out.println("算法A的实现");
    }
}