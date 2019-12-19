package com.jiaty.demo.date20190731;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.EnumSet;

/**
 * @program: Practice
 * @description: 枚举
 * @author: jiaty
 * @create: 2019-07-31 16:07
 **/

public class EnumDemo {


    public static final int RED = 0x1;

    public static final int GREEN = 0x2;

    public static final int BLUE  = 0x3;

    public int color;

    @Test
    public void test1(){

        color = RED;
        color = 4;

    }

    public Color colorEnum;
    public Color colorEnum2;

    @Test
    public void test2(){

//        colorEnum = Color.BLUE;
//        colorEnum = Color.GREEN;
        colorEnum = Color.RED;
        colorEnum2 = Color.GREEN;

        Color[] colors = Color.values();  //获取枚举类中的所有值

        System.out.println(colorEnum);
        System.out.println(colorEnum.name());
        System.out.println(colorEnum2.ordinal());           //枚举的序号  0，1，2，3，4，5
        System.out.println(colorEnum.compareTo(colorEnum2));   //compareTo这是一个比较枚举类中不同值的方法。colorEnum - colorEnum2.

        System.out.println(Arrays.toString(colors));
    }


    @Test
    public void test3(){

        EnumSet<Color> eset = EnumSet.allOf(Color.class);
        for(Color c: eset){
            System.out.println(c);
        }

        EnumMap<Color,String> emap = new EnumMap(Color.class);
        emap.put(Color.GREEN,"green");
        emap.put(Color.RED,"red");
        emap.put(Color.BLUE,"blue");
        System.out.println(emap.toString());
    }

    @Test
    public void test4(){

        System.out.println(Color.RED);
        //由此可见，调用枚举类中一个元素，就会加载整个枚举类，最后输出属性值


    }



}