package com.leetcode.thirtydayschallenge;

import java.util.Arrays;
import java.util.List;

public class SingleNumber {

    // https://leetcode.com/problems/single-number/
    public static void main(String[] args) {

       //  1. Brute Force - O(N^2)
       // 2. Using property of XOR - (0 0 - 0),(0 1- 1),(1 0 - 1),(1 1 - 0)   -  O(N)

        List<Integer> nums = Arrays.asList(1,2,1,2,4);

        int result  = 0;
        for(int i = 0;i<nums.size();i++){
            result ^= nums.get(i);
        }

        System.out.println("Result: "+result);

    }
}
