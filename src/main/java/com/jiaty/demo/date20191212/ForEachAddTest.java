package com.jiaty.demo.date20191212;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * @program: Practice
 * @description: 在foreach中做加减操作，会不会生效
 * @author: jiaty
 * @create: 2019-12-12 14:58
 **/

public class ForEachAddTest {


    public static void main(String[] args) {

        BigDecimal total = BigDecimal.ZERO;
        List<String> ids = new ArrayList<>();
        ids.add("12312");
        ids.add("12312");
        ids.add("12312");
        ids.add("12312");
        ids.add("12312");

//        ids.stream().forEach(id ->{
        for (String id : ids) {
            total = total.add(BigDecimal.TEN);
        }

        System.out.println(total);

    }
}