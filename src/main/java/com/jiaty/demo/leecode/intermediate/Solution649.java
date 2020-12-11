package com.jiaty.demo.leecode.intermediate;

import java.util.*;

/**
 * @program: practice
 * @description: Dota2参议院
 * @author: Jiaty
 * @create: 2020-12-11 09:34
 **/

public class Solution649 {

    /**
     * Wrong
     *
     * @param senate
     * @return
     */
    public String predictPartyVictory(String senate) {
        Character R = 'R';
        Stack<Character> stack = new Stack<>();
        stack.push(senate.charAt(0));
        for (int i = 1; i < senate.length(); i++) {
            if (!stack.isEmpty() && !stack.peek().equals(senate.charAt(i))) {
                stack.pop();
            } else {
                stack.push(senate.charAt(i));
            }
        }
        if (stack.isEmpty()) {
            if (R.equals(senate.charAt(0))) {
                return "Radiant";
            } else {
                return "Dire";
            }
        } else {
            if (R.equals(senate.charAt(senate.length() - 1))) {
                return "Radiant";
            } else {
                return "Dire";
            }
        }
    }

    /**
     * Wrong
     *
     * @param senate
     * @return
     */
    public String predictPartyVictory1(String senate) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < senate.length(); i++) {
            map.put(senate.charAt(i), map.getOrDefault(senate.charAt(i), 0) + 1);
        }
        char r = 'R';
        char d = 'D';
        int rNums = map.get(r);
        int dNums = map.get(d);
        if (rNums == dNums) {
            return senate.charAt(0) == r ? "Radiant" : "Dire";
        } else if (rNums > dNums) {
            return "Radiant";
        } else {
            return "Dire";
        }
    }

    /**
     * 想用双指针
     * @param senate
     * @return
     */
    public String predictPartyVictory2(String senate) {
        char r = 'R';
        char d = 'D';
        int low = 0;
        int fast = 1;
//        while (fast < senate.length()) {
//
//        }
        return null;
    }

    public String predictPartyVictory3(String senate) {
        int n = senate.length();
        Queue<Integer> radiant = new LinkedList<>();
        Queue<Integer> dire = new LinkedList<>();
        for (int i = 0; i < n; ++i) {
            if (senate.charAt(i) == 'R') {
                radiant.offer(i);
            } else {
                dire.offer(i);
            }
        }
        while (!radiant.isEmpty() && !dire.isEmpty()) {
            int radiantIndex = radiant.poll(), direIndex = dire.poll();
            if (radiantIndex < direIndex) {
                radiant.offer(radiantIndex + n);
            } else {
                dire.offer(direIndex + n);
            }
        }
        return !radiant.isEmpty() ? "Radiant" : "Dire";
    }

    public String predictPartyVictory4(String senate) {
        int Rnumber = 0;//R阵营总人数
        int Dnumber = 0;//D阵营总人数
        int curBanR = 0;//当前被ban
        int curBanD = 0;//当前被ban
        int totalBanR = 0;//被ban总数
        int totalBanD = 0;//被ban总数
        char[] chars = senate.toCharArray();
        boolean flag = true;
        while(true){
            for(int i = 0;i < chars.length;i++){
                char cur = chars[i];
                if(cur == 'R'){
                    if(flag)
                        Rnumber++;
                    if(curBanR == 0){
                        curBanD++;
                        totalBanD++;
                        if(totalBanD == Dnumber  && !flag)return "Radiant";
                    }else{
                        curBanR--;
                        chars[i] = 'r';
                    }
                }else if(cur == 'D'){
                    if(flag)
                        Dnumber++;
                    if(curBanD == 0){
                        curBanR++;
                        totalBanR++;
                        if(totalBanR == Rnumber  && !flag)return "Dire";
                    }else{
                        curBanD--;
                        chars[i] = 'd';
                    }
                }
            }
            flag = false;
            if(totalBanD >= Dnumber)return "Radiant";
            if(totalBanR >= Rnumber)return "Dire";
        }
    }
}