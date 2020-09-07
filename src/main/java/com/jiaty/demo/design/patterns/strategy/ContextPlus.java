package com.jiaty.demo.design.patterns.strategy;

/**
 * @program: practice
 * @description: 修改版
 * @author: Jiaty
 * @create: 2020-09-07 14:19
 **/

public class ContextPlus {

    private StrategyPlus strategyPlus;


    ContextPlus(String type){
        switch (type){
            case "A":
                strategyPlus = new ConcreteStrategyAPlus();
                break;
            case "B":
                strategyPlus = new ConcreteStrategyBPlus();
                break;
            case "C":
                strategyPlus = new ConcreteStrategyBPlus();
                break;
            default:
                break;
        }
    }

    public void contextInterface() {
        strategyPlus.arithmInterface();
    }

}