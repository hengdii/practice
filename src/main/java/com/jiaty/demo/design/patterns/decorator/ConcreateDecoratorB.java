package com.jiaty.demo.design.patterns.decorator;

/**
 * @program: practice
 * @description:
 * @author: Jiaty
 * @create: 2020-09-07 16:30
 **/

public class ConcreateDecoratorB extends Decorator {

    @Override
    void operation() {
        super.operation();
        //首先运行原Component的operation，再执行本类的功能，如AddedBehavior。相对于对原Component进行了装饰
        AddedBehavior();
        System.out.println("具体装饰对象B的操作");
    }


    private void AddedBehavior(){

    }
}