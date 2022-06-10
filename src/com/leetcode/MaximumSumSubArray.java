package com.leetcode;

public class MaximumSumSubArray {

    // kadane algorithm
    public static void main(String[] args) {

        int arr[] = {-5,4,6,-3,4,-1};


        System.out.println("Max sum using brute force: " +findMaximumSumSubArrayV1(arr));

        System.out.println("Max sum using kadane algorithm: " +findMaximumSumSubArrayV2(arr));


    }

    // O(n^2)
    private static int findMaximumSumSubArrayV1(int[] arr) {
        int n = arr.length;
        int maxSum = 0;
        for(int i = 0;i <n;i++){
            int sum = 0;
            for(int j = i; j<n ;j++){
                sum = sum + arr[j];
                if(sum > maxSum)
                    maxSum = sum;
            }
        }
        return maxSum;
    }

    // O(n) using kadane algorithm
    private static int findMaximumSumSubArrayV2(int[] arr) {

        int maxSum = 0;
        int currSum = 0;

        for(int i = 0;i<arr.length;i++){
            currSum = currSum + arr[i];
            if(currSum > maxSum)
                maxSum = currSum;
            if(currSum < 0 )
                currSum = 0;
        }
        return  maxSum;
    }

}
