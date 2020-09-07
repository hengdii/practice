package com.jiaty.demo.design.patterns.decorator;

/**
 * @program: practice
 * @description: 装饰器客户端
 * @author: Jiaty
 * @create: 2020-09-07 16:33
 **/

public class DecoratorClient {

    public static void main(String[] args) {

        ConcreateComponent c = new ConcreateComponent();
        ConcreateDecoratorA a = new ConcreateDecoratorA();
        ConcreateDecoratorB b = new ConcreateDecoratorB();

        a.setComponent(c);
        b.setComponent(a);
        b.operation();

    }
}