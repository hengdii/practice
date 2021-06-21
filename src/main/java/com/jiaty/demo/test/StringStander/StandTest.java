package com.jiaty.demo.test.StringStander;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @program: practice
 * @description:
 * @author: tengyu5
 * @create: 2021/06/21 16:14
 **/

public class StandTest {

    public static void main(String[] args) {
        String s = "资生堂丽源（化妆品)北京有限公司";

        s = NameStander.nameStander(s);

        //匹配时忽略（） () 全角括号和半角括号
        String regex = "^[a-zA-Z\u4E00-\u9FA5-()-（）/[1-9]\\d*]+$";
        Pattern pattern = Pattern.compile(regex);
        Matcher match = pattern.matcher(s);
        boolean a = match.matches();

        if (!a) {
            throw new RuntimeException("代理商公司名称：" + s + "不符合规范");
        }

//        String s1 = NameStander.nameStander(s);

        System.out.printf(s);

    }
}