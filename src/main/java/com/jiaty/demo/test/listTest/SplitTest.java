package com.jiaty.demo.test.listTest;

//import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @program: practice
 * @description: 测试stream和split ,以及转义字符  . |
 * @author: jiaty
 * @create: 2019-12-20 14:33
 **/

public class SplitTest {
    public static void main(String[] args) {
//        List<String> s = Lists.newArrayList();
        List<String> s = new ArrayList<>();
        String url = "92.0.0";
        Arrays.stream(url.split("\\.")).map(u -> {
            s.add(u);
            return s;
        }).collect(Collectors.toList());
        System.out.println(s);


        String url2 = "92|0|0";

        Arrays.stream(url2.split("\\|")).map(u -> {
            s.add(u);
            return s;
        }).collect(Collectors.toList());
        System.out.println(s);


    }

}