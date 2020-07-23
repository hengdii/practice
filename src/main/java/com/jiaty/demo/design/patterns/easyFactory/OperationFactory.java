package com.jiaty.demo.design.patterns.easyFactory;

/**
 * @program: Practice
 * @description: 简单工厂
 * @author: Jiaty
 * @create: 2020-07-23 10:51
 **/

public class OperationFactory {


    public static Operation operationCreate(String operate) {
        if (operate == null) {
            return null;
        }
        Operation operation;
        switch (operate) {
            case "+":
                operation = new OperationAdd();
                break;
            case "-":
                operation = new OperationSub();
                break;
            case "*":
                operation = new OperationMul();
                break;
            case "/":
                operation = new OperationDiv();
                break;
            default:
                operation = null;
                break;
        }
        return operation;
    }


}