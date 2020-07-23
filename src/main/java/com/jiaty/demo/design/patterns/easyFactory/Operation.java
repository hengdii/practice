package com.jiaty.demo.design.patterns.easyFactory;

import lombok.Getter;
import lombok.Setter;

/**
 * @program: Practice
 * @description: 运算类
 * @author: Jiaty
 * @create: 2020-07-21 13:45
 **/

public class Operation {
    @Setter
    @Getter
    private double numberA = 0;
    @Setter
    @Getter
    private double numberB = 0;

    public double getResult() {
        return 0;
    }


}