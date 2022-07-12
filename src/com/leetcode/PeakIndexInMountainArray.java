package com.leetcode;

public class PeakIndexInMountainArray {

    // https://leetcode.com/problems/peak-index-in-a-mountain-array/
    public static void main(String[] args) {

        int arr[] = {0,2,1,0};

        System.out.println("Peak Index in mountain array: "+findPeakIndexInMountainArray(arr));

    }

    private static int findPeakIndexInMountainArray(int[] arr) {
        int left = 0;
        int right = arr.length -1;

        while(left < right){
            int midPoint = left + (right - left)/2;
            if(arr[midPoint] < arr[midPoint + 1]){
                left = midPoint + 1;
            }else{
                right = midPoint;
            }
        }
        return left;
    }
}
