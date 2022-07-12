package com.leetcode;

import java.util.Arrays;

public class ThreeSumClosest {


    // https://leetcode.com/problems/3sum-closest/
    public static void main(String[] args) {

        int arr[] = {-1,2,1,-4};
        int target = 1;

        System.out.println("Closest sum: "+threeSumClosest(arr,target));

    }

    private static int threeSumClosest(int[] nums, int target) {
            int res = nums[0] + nums[1] + nums[nums.length -1 ];
        Arrays.sort(nums);
        for(int i = 0;i< nums.length-2;i++){
            int aPointer = i + 1;
            int bPointer = nums.length - 1;

            while(aPointer < bPointer){
                int currentSum = nums[i] + nums[aPointer] + nums[bPointer];
                if(currentSum > target){
                    bPointer -= 1;
                }else{
                    aPointer += 1;
                }
                if(Math.abs(currentSum-target) < Math.abs(res - target)){
                    res = currentSum;
                }
            }
        }
        return res;
    }
}
