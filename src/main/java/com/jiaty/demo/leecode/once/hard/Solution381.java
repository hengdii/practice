package com.jiaty.demo.leecode.once.hard;

import java.util.*;

/**
 * @program: practice
 * @description: Solution381
 * @author: Jiaty
 * @create: 2020-10-31 22:21
 **/

public class Solution381 {

    Map<Integer, Set<Integer>> idx;

    List<Integer> nums;

    public Solution381() {
        idx = new HashMap<>();
        nums = new ArrayList<>();
    }

    public boolean insert(int val) {
        nums.add(val);
        Set<Integer> set = idx.getOrDefault(val, new HashSet<>());
        set.add(nums.size() - 1);
        idx.put(val, set);
        return idx.size() == 1;
    }

    public boolean remove(int val) {
        if (!idx.containsKey(val)) {
            return false;
        }
        Iterator<Integer> it = idx.get(val).iterator();
        int i = it.next();
        int lastNum = nums.get(nums.size() - 1);
        nums.set(i, lastNum);
        idx.get(val).remove(i);
        idx.get(lastNum).remove(nums.size() - 1);
        if (i < nums.size() - 1) {
            idx.get(lastNum).add(i);
        }
        if (idx.get(val).size() == 0) {
            idx.remove(val);
        }
        nums.remove(nums.size() - 1);
        return true;
    }


    public int getRandom() {
        return nums.get((int) Math.random() * nums.size());
    }


}