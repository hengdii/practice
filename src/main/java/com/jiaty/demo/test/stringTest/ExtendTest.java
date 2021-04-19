package com.jiaty.demo.test.stringTest;

/**
 * @program: practice
 * @description: 继承
 * @author: Jiaty
 * @create: 2021-04-11 17:26
 **/

public class ExtendTest {

    static class father{
        public String name = "爸爸";
    }

    static class son extends father{
        public String name = "儿子";
    }

    public static void main(String[] args) {
        father s = new son();
        System.out.println(s.name);
    }
}