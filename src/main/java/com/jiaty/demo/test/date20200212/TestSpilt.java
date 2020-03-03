package com.jiaty.demo.test.date20200212;

import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;
import java.util.List;

/**
 * @program: Practice
 * @description: 下划线分隔符
 * @author: Jiaty
 * @create: 2020-02-12 10:35
 **/

public class TestSpilt {
    public static void main(String[] args) {

        String path = "1001_1002_1003";

        String[] s = StringUtils.split(path, "_");
        List<String> list = Arrays.asList(s);

        System.out.println(list.get(0));
        System.out.println(list.get(1));
        System.out.println(list.get(2));

//        List<String> list1 = Arrays.asList(s);
        String s1 = StringUtils.joinWith(",", list);
        String join = String.join(",", list);
        System.out.println(join);

    }
}