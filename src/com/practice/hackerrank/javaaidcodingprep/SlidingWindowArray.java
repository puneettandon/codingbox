package com.practice.hackerrank.javaaidcodingprep;

public class SlidingWindowArray {

    /* Problem Statement:
    Given an array of integers n and a positive number k, find the maximum sum of any contiguous subarray of size k

    Example -1 :  [ 2,1,5,1,3,2], k= 3
    output : 9
    Explanation: [5,1,3]
     */

    // https://www.youtube.com/watch?v=__guhvzO540
    public static void main(String[] args) {

        int arr[] = {2,1,5,1,3,2};
        int arr1[] = {1,9,-1,-2,7,3,-1,2};
        int k = 3;
        int k1 = 4;

        System.out.println("Max Sum Sub Array  using brute force: "+getMaxSumSubArrayOfSizeKUsingBruteForce(arr1,k1));

        System.out.println("Max Sum Sub Array  using sliding window technique: "+getMaxSumSubArrayOfSizeKUsingSlidingWindow(arr1,k1));

        System.out.println("Max Sum Sub Array  using sliding window technique v2: "+getMaxSumSubArrayOfSizeKUsingSlidingWindowV2(arr1,k1));

    }

    private static int getMaxSumSubArrayOfSizeKUsingSlidingWindowV2(int[] arr, int k) {
        int windowSum = 0;
        int maxSum = 0;

        for(int i = 0;i<k;i++)
            windowSum += arr[i];

        for(int end = k;end <arr.length;end++){
            windowSum += arr[end] - arr[end-k];
            maxSum = Math.max(maxSum,windowSum);
        }
        return maxSum;
    }

    // time complexity - O(n)
    private static int getMaxSumSubArrayOfSizeKUsingSlidingWindow(int[] arr, int k) {
        int windowSum = 0;
        int maxSum = 0;
        for(int i = 0;i<arr.length;i++){
            if((i+1) > k ){
                windowSum += arr[i] -arr[i-k];
                }else{
                    windowSum += arr[i];
                }
            maxSum = Math.max(windowSum,maxSum);
            }
        return maxSum;
    }

    // time complexity - O(n*k)
    private static int getMaxSumSubArrayOfSizeKUsingBruteForce(int[] arr, int k) {

        int maxSum = 0;
        for(int i = 0;i<arr.length-k;i++){
            int windowSum = 0;
            for(int j = i;j<i+k;j++){
                windowSum +=  arr[j];
            }
            maxSum = Math.max(maxSum,windowSum);
        }
        return maxSum;
    }
}
