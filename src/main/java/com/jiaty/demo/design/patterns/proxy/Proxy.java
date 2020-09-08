package com.jiaty.demo.design.patterns.proxy;

/**
 * @program: practice
 * @description:
 * @author: Jiaty
 * @create: 2020-09-08 10:13
 **/

public class Proxy extends Subject {

    private RealSubject realSubject;

    @Override
    void request() {
        if (realSubject == null){
            realSubject = new RealSubject();
        }
        realSubject.request();
    }
}