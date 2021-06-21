package com.jiaty.demo.test.StringStander;

import io.netty.util.internal.StringUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @program: practice
 * @description: 名称的规范化校验
 * @author: tengyu5
 * @create: 2021/06/21 16:12
 **/

@Slf4j
public class NameStander {

    /**
     * 全角转换为半角
     *
     * @param input
     * @return 半角字符串
     */
    public static String toDBC(String input) {
        char[] c = input.toCharArray();
        for (int i = 0; i < c.length; i++) {
            if (c[i] == '\u3000') {
                c[i] = ' ';
            } else if (c[i] > '\uFF00' && c[i] < '\uFF5F') {
                c[i] = (char) (c[i] - 65248);
            }
        }
        String returnString = new String(c);
        return returnString;
    }

    public static String nameStander(String input) {
        if (StringUtil.isNullOrEmpty(input)) {
            return input;
        } else {
            // 汉字发现半角括号转全角括号
            if (containsHanScript(input)) {
                input = bracketToSBC(input).trim();

            }else {
                // 其余情况统一半角
                input = toDBC(input).trim();
            }
            return input;
        }
    }

    public static boolean containsHanScript(String s) {
        return s.codePoints().anyMatch(
                codepoint ->
                        Character.UnicodeScript.of(codepoint) == Character.UnicodeScript.HAN);
    }

    // 半角括号转全角括号
    public static String bracketToSBC(String input) {
        if (StringUtils.isBlank(input)) {
            return input;
        }
        char[] charArray = input.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            // 全角括号不处理
            if (charArray[i] == '\uFF08' || charArray[i] == '\uFF09') {
                // 半角括号转全角
            } else if (charArray[i] == '\u0028' || charArray[i] == '\u0029') {
                charArray[i] = (char) (charArray[i] + 65248);
                // 中文下输入空格单独转
            } else if (charArray[i] == '\u3000') {
                charArray[i] = ' ';
                // 其余字符全角转半角
            } else if (charArray[i] > '\uFF00' && charArray[i] < '\uFF5F') {
                charArray[i] = (char) (charArray[i] - 65248);
            }
        }
        return new String(charArray);
    }

    public static String nameStanderForLike(String input) {
        if(StringUtil.isNullOrEmpty(input)){
            return input;
        }else{
            input = escapeStringForMySQL(toDBC(input).trim());
            return input;
        }
    }

    public static String escapeStringForMySQL(String s) {
        return s.replaceAll("\\\\","\\\\\\\\");
    }


    /**
     * @Description: 字符转换
     * @Param: [input]
     * @return: java.lang.String
     * @Author: pengyi1
     * @Date: 1/11/18
     */
    public static String replaceBlank(String str){
        String[] enSymbol = {"\"", "'", ",", "[.]", ";", "...", "&", "\t", "\n", "\r"};
        //后面的想换成什么字符
        String[] cnSymbol = {"“", "‘", "，", "。", "；", "……", "", "", "", ""};
        for (int i=0; i<enSymbol.length; i++) {
            str = str.replaceAll(enSymbol[i], cnSymbol[i]);
        }
        return str;
    }

    public static String escapseSpecialChar(String query) {
        if (StringUtils.isNotBlank(query)) {
            query = query
//                .replaceAll("/", "//")  右斜杠不需替换
                    .replaceAll("\\\\", "\\\\\\\\")
                    .replaceAll("%", "\\\\%").replaceAll("_", "\\\\_");
        }
        return query;
    }

    /**
     * @Description: 检查对象中string类型参数，标准化名称
     * @Param: [obj]
     * @return: void
     * @Author: pengyi1
     * @Date: 1/11/18
     */
    public static void objectStander(Object obj){
        if(obj != null){
            Field[] fields = obj.getClass().getDeclaredFields();
            Method[] methods = obj.getClass().getMethods();
            for (Field field : fields) {
                String name = field.getName();
                String type = field.getGenericType().toString();
                if ("class java.lang.String".equals(type)) {
                    Method method = null;
                    try {
                        method = obj.getClass().getMethod("get" + name.substring(0, 1).toUpperCase() + name.substring(1));
                        String value = (String) method.invoke(obj);
                        field.setAccessible(true);
                        field.set(obj,nameStander(value));
                    } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
                        e.printStackTrace();
                        log.info("格式转换有误："+obj.getClass().toString()+"   |   "+obj.toString());
                    }
                }
            }
        }
    }

}