package com.jiaty.demo.date20190731;

/**
 * 定义一个枚举类型
 */
public enum Color {

    RED(10),GREEN(20),BLUE;
    private int i;
    Color(){
        System.out.println("无参构造器");
    }
    Color(int i) {
        String name = "";
        this.i = i;
        switch (i){
            case 10:
                name = "小红";
                break;
            case 20:
                name = "小绿";
                break;
        }
        System.out.println("我是"+name);
    }
}
