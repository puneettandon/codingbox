package com.leetcode;

public class SingleNumber {

    // https://leetcode.com/explore/interview/card/top-interview-questions-easy/92/array/549/
    // https://www.youtube.com/watch?v=qMPX1AOa83k
    public static void main(String[] args) {

        int arr[] = {4,1,2,1,2};

        // 4 - 100
        // 1 - 001 = 101
        // 2 - 010 = 111
        // 1 - 001 = 110
        // 2 - 010 = 100  ==  4

        System.out.println("Single Number using xor approach : "+findNonDuplicateNumber(arr));
    }

    private static int findNonDuplicateNumber(int[] arr) {

        int res = 0;
        for(int i = 0;i<arr.length;i++){
            res = res  ^ arr[i];
        }
        return res;
    }
}
