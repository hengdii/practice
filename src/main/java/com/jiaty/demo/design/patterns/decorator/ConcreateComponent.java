package com.jiaty.demo.design.patterns.decorator;

/**
 * @program: practice
 * @description:
 * @author: Jiaty
 * @create: 2020-09-07 16:26
 **/

public class ConcreateComponent extends Component{


    @Override
    void operation() {
        System.out.println("具体的对象操作");
    }
}