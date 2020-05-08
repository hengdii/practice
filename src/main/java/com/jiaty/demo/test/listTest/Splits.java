package com.jiaty.demo.test.listTest;


import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;
import java.util.List;

/**
 * @program: practice
 * @description:
 * @author: jiaty
 * @create: 2019-12-25 16:42
 **/

public class Splits {

    public static void main(String[] args) {
        String s = "12332132";
        List<String> s1 = Arrays.asList(StringUtils.split(s, ","));
        System.out.println(s1);

    }

}