package com.jiaty.demo.design.patterns.strategy;

/**
 * @program: Practice
 * @description: 上下文对象
 * @author: Jiaty
 * @create: 2020-07-23 11:30
 **/

public class Context {

    private Strategy strategy;

    Context(Strategy strategy) {
        this.strategy = strategy;
    }

    public void contextInterface() {
        strategy.arithmInterface();
    }
}