package com.jiaty.demo.date20190820;

/**
 * @program: Practice
 * @description: 裁剪
 * @author: jiaty
 * @create: 2019-08-20 17:58
 **/

public class ToStringDemo {


    public static void main(String[] args) {

        String url = "http://localhost:8 080/swagger-ui.html ";
        System.out.println(url.replaceAll(" ", "20%"));

        String urlold = "http://localhost:808  0/swagger-ui.html ";
        System.out.println(urlold.substring(0, url.length() - 1) + "20%");
    }
}