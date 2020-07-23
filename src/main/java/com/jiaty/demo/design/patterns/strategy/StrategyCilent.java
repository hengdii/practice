package com.jiaty.demo.design.patterns.strategy;

/**
 * @program: Practice
 * @description: 客户端
 * @author: Jiaty
 * @create: 2020-07-23 11:33
 **/

public class StrategyCilent {


    public static void main(String[] args) {
        Context context;
        context = new Context(new ConcreteStrategyA());
        context.contextInterface();

        context = new Context(new ConcreteStrategyB());
        context.contextInterface();

        context = new Context(new ConcreteStrategyC());
        context.contextInterface();


    }
}