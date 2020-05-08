package com.jiaty.demo.test.listTest;

import org.springframework.scheduling.annotation.Async;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * @program: Practice
 * @description: List的Equals
 * @author: Jiaty
 * @create: 2020-04-26 13:53
 **/

public class ListEquals {


    public static void main(String[] args) {
//        ["1231231","12312312","12312312"]
        List<String> str1 = new ArrayList<>();
        str1.add("1231231");
        str1.add("12312312");
        str1.add("1");
        str1.add("123123121");
        //排序之后是没有问题的
        str1.sort(Comparator.comparing(Long::parseLong));
        System.out.println(str1);
        List<String> str2 = new ArrayList<>();
        str2.add("1");
        str2.add("1231231");
        str2.add("123123121");
        str2.add("12312312");
        str2.sort(Comparator.comparing(Long::parseLong));
        System.out.println(str2);
//        str2.add("123");
        System.out.println(str1.equals(str2));
    }
}