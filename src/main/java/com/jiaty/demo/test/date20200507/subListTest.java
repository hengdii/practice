package com.jiaty.demo.test.date20200507;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class subListTest {

    private static final int PAGE_SIZE = 50;

    public static void main(String[] args) {
        List<Integer>  numberList = new ArrayList<>();

        for (int i = 0;i<=10000;i++){
            numberList.add(i);
        }

        int start = 0;
        for (int i = 0; i <= numberList.size() / PAGE_SIZE; i++) {
            List<Integer> thisTimeItemIds = numberList.subList(start, i == numberList.size() / PAGE_SIZE ? numberList.size() : start + PAGE_SIZE);
            start = start + PAGE_SIZE;
            log.info("i:{},thisTimeSkuIds:{}", i, thisTimeItemIds);
        }
    }


}
