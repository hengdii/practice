package com.jiaty.demo.test.numberTest;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

/**
 * @program: Practice
 * @description: 关于bigdecimal的compareTo和equals方法的区别
 * @author: Jiaty
 * @create: 2020-07-02 17:02
 **/

public class BigDecimalCompareAndEqualsTest {

    public static void main(String[] args) {
        BigDecimal one = BigDecimal.valueOf(1.0);
        BigDecimal two = BigDecimal.valueOf(1.00);
        BigDecimal oneString = new BigDecimal("1.0");
        BigDecimal twoString = new BigDecimal("1.00");

        Set<BigDecimal> set = new HashSet<>();
        Set<BigDecimal> treeSet = new TreeSet<>();

//        set.add(one);
//        set.add(two);
//        treeSet.add(one);
//        treeSet.add(two);

        set.add(oneString);
        set.add(twoString);
        treeSet.add(oneString);
        treeSet.add(twoString);

        System.out.println("one.compareTo(two)" + one.compareTo(two));
        System.out.println("one.equals(two)" + one.equals(two));
        System.out.println("oneString.compareTo(twoString)" + oneString.compareTo(twoString));
        System.out.println("oneString.equals(twoString)" + oneString.equals(twoString));
        System.out.println("two.compareTo(twoString)"+two.compareTo(twoString));
        System.out.println("one.equals(twoString)"+one.equals(twoString));

        System.out.println("one.equals(oneString)"+one.equals(oneString));

        System.out.println(set);
        System.out.println(treeSet);
    }


}