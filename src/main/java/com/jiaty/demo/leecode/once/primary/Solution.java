package com.jiaty.demo.leecode.once.primary;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @program: practice
 * @description:
 * @author: Jiaty
 * @create: 2020-08-19 16:17
 **/

public class Solution {
    /**
     * 大神们, 求一道算法啊
     * 已知一个List<String>
     * list.add("123");
     * list.add("1");
     * list.add("123456");
     * list.add("123");
     * list.add("124");
     * 从list中求出一个集合, 里面的元素彼此没有包含关系(去掉被包含的)
     * 比如上面的元素123包含1, 那么取123; 123456包含123, 取123456
     * 最后要的集合肯定只有两个元素, 就是123456和124
     * <p>
     * 还有（前缀树
     */


    public static List<String> getNotRepeatingList(List<String> list) {
        if (list.size() == 0 || list.size() == 1) {
            return list;
        }
        List<String> stringList = new ArrayList<>();
        //这一步是因为假如说有重复的，他就不保留
        list = new CopyOnWriteArrayList<>(list);
        for (int i = 0; i < list.size(); i++) {
            int j = list.size() - 1;
            boolean flg = false;
            while (j > -1) {
                if (j == i || j == i + 1) {
                    j--;
                    continue;
                }
                if (list.get(j).contains(list.get(i))) {
                    flg = true;
                    break;
                }
                j--;
            }
            if (!flg) {
                stringList.add(list.get(i));
                list.remove(i);
            }
        }
        return stringList;
    }


    public static List<String> getNotRepeat(List<String> list) {
        Iterator<String> ite = list.iterator();
        while (ite.hasNext()) {
            String s = ite.next();
            for (int i = 0; i < list.size(); i++) {
                if (list.indexOf(s) == i) {
                    continue;
                }
                if (list.get(i).contains(s)) {
                    ite.remove();
                    break;
                }
            }
        }
        return new ArrayList<>();
    }


    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("123");
        list.add("1");
        list.add("12234567");
        list.add("123");
        list.add("12345678");
        list.add("12345678");
        list.add("1246");
        System.out.println(getNotRepeatingList(list));
//        System.out.println(getNotRepeat(list));
    }


}