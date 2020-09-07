package com.jiaty.demo.design.patterns.strategy;

/**
 * @program: Practice
 * @description: 客户端
 * @author: Jiaty
 * @create: 2020-07-23 11:33
 **/

public class StrategyCilent {

    /**
     * 策略模式是一种定义一系列算法的方法，从概念上来看，所有这些算法完成的都是相同的工作，只是实现不同，
     * · 它们可以以相同的方式调用所有的算法，减少了各种算法类与使用算法类之间的耦合
     * · strategy 类层次为context定义了一系列的可供重用的算法或行为。继承有助于析取这些算法中的公用功能。
     * · 简化了单元测试，因为每个算法都有自己的类，可以通过自己的接口单独测试
     *
     *
     *
     *
     */

    public static void main(String[] args) {
        /**
         * 策略模式 + 简单工厂模式
         */
        //客户端判断使用哪个代码  不够扩展
        Context context;
        context = new Context(new ConcreteStrategyA());
        context.contextInterface();

        context = new Context(new ConcreteStrategyB());
        context.contextInterface();

        context = new Context(new ConcreteStrategyC());
        context.contextInterface();

        //通过字符串去判断
        String type = "";
        ContextPlus contextPlus = new ContextPlus(type);
        contextPlus.contextInterface();


    }

}