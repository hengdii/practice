package com.jiaty.demo.test.stringTest;

import org.apache.commons.lang3.StringUtils;

/**
 * @program: Practice
 * @description:
 * @author: Jiaty
 * @create: 2020-05-08 14:18
 **/

public class StringUtilsTest {

    public static void main(String[] args) {

        String s  = "1232131x23";

        System.out.println(StringUtils.isNumeric(s));


        String s1 = "1x";

        System.out.println(StringUtils.isAlphanumeric(s));

    }

}