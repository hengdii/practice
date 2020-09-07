package com.jiaty.demo.design.patterns.decorator;

/**
 * @program: practice
 * @description:
 * @author: Jiaty
 * @create: 2020-09-07 16:30
 **/

public class ConcreateDecoratorA extends Decorator {

    private String addedState;

    @Override
    void operation() {
        super.operation();
        addedState = "new State";
        System.out.println("具体装饰对象A的操作");
    }
}