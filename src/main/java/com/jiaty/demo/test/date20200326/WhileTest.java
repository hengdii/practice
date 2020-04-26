package com.jiaty.demo.test.date20200326;

/**
 * @program: Practice
 * @description: while语句
 * @author: Jiaty
 * @create: 2020-03-26 13:51
 **/

public class WhileTest {

    public static void main(String[] args) {

        for (int i = 0; i <= 2; i++) {
            boolean flg = true;
            while (flg) {
                for (int j = 0; j <= 4; j++) {
                    System.out.println("kaishi");
                    if (j == 3) {
                        flg = false;
                        break;
                    }
                    System.out.println("jieshu");
                }

            }
        }

    }
}