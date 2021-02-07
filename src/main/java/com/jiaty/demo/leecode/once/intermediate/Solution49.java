package com.jiaty.demo.leecode.once.intermediate;

import java.util.*;

/**
 * @author Jiaty
 * @date 2020/12/14 18:25
 */
public class Solution49 {

    public List<List<String>> groupAnagrams(String[] strs){
        Map<String,List<String>> map = new HashMap<>();
        for (String s :strs){
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            String key = String.valueOf(chars);
            if (!map.containsKey(key)){
                map.put(key,new ArrayList<>());
            }
            map.get(key).add(s);
        }
        return new ArrayList<>(map.values());
    }

    /**
     * 速率较慢
     *
     * @param strs
     * @return
     */
    public List<List<String>> groupAnagrams1(String[] strs){
        Map<String,List<String>> map = new HashMap<>();
        for (String s : strs){
            int [] count = new int[26];
            int len = s.length();
            for (int i = 0; i < len; i++) {
                count[s.charAt(i) - 'a']++;
            }
            //将每次出现次数大于0的字母和出现次数按顺序拼接成字符串，作为哈希表的key
            StringBuffer stringBuffer = new StringBuffer();
            for (int i = 0; i < 26; i++) {
                if (count[i]!=0){
                    stringBuffer.append((char)'a' + i);
                    stringBuffer.append(count[i]);
                }
            }
            String key = stringBuffer.toString();
            List<String> list = map.getOrDefault(key,new ArrayList<>());
            list.add(s);
            map.put(key,list);
        }
        return new ArrayList<>(map.values());


    }








}
