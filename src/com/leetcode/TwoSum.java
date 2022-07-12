package com.leetcode;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class TwoSum {

    //https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/
    public static void main(String[] args) {

        int arr[] = {2,7,11,15};
        int target = 9;

        int res[] = twoSumSorted(arr,target);

        Arrays.stream(res).forEach(e -> System.out.println(e));

    }

    private static int[] twoSumSorted(int[] arr, int target) {

        int a_pointer = 0;
        int b_pointer = arr.length-1;

        while(a_pointer <= b_pointer){
            int sum = arr[a_pointer] + arr[b_pointer];
            if(sum > target){
                b_pointer -=1;
            }else if(sum < target){
                a_pointer += 1;
            }else{
                return new  int[]{a_pointer+1,b_pointer+1};
            }
        }
        return new int[]{a_pointer+1,b_pointer+1};
    }
}
