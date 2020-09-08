package com.jiaty.demo.design.patterns.proxy;

/**
 * @program: practice
 * @description:
 * @author: Jiaty
 * @create: 2020-09-08 10:12
 **/

public class RealSubject extends Subject{

    @Override
    void request() {
        System.out.println("真实的请求");
    }
}