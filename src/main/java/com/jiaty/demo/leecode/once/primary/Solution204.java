package com.jiaty.demo.leecode.once.primary;

/**
 * @program: practice
 * @description: 计数质数
 * @author: Jiaty
 * @create: 2020-12-03 10:20
 **/

public class Solution204 {

    public static int countPrime(int n){
        if(n == 0){
            return 0;
        }
        int ans = 0;
        for(int i = 1;i<n;i++){
            if(isPrime(i)){
                ans++;
            }
        }
        return ans;
    }


    private static boolean isPrime(int n){
        int a = 2;
        for(;a < n;a++){
            if(n % a != 0){
                a++;
            }
        }
        if(n == a - 2){
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(countPrime(10));

    }


}