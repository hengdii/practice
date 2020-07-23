package com.jiaty.demo.design.patterns.easyFactory;

/**
 * @program: Practice
 * @description: 客户端
 * @author: Jiaty
 * @create: 2020-07-23 10:58
 **/

public class OperateClient {

    /**
     * 简单工厂模式，将实例话对象的方法封装起来，根据不同的情况实例不同的子类，子类中重写父类的方法，从而达到一个灵活的效果
     * （出现需要添加的功能，就可以直接添加子类并且在factory中添加分支达到目的）
     * <p>
     * ps:乘法还可以看出，double丢失精度
     *
     * @param args
     */
    public static void main(String[] args) {
        Operation operation;
        operation = OperationFactory.operationCreate("*");
        operation.setNumberA(1.1);
        operation.setNumberB(0.1);
        System.out.println(operation.getResult());

    }
}