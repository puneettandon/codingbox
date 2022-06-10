package com.practice.hackerrank.javaaidcodingprep;

import java.util.Arrays;

public class TwoPointer {

    // https://www.youtube.com/watch?v=2wVjt3yhGwg
    /*
    what is two pointer technique?
        Two pointer technique is normally used for searching and it uses two pointer in one loop over
        the given data structure. This is quite common approach which used to solve coding problems,
        mostly related to string,arrays and linkedlist

    why you must know it?
        In order to use two pointers, most of the times the data structure needs to be ordered in
        some way, which helps us to reduce time complexity from O(n^2) or O(n^3) to O(n) of just
        one loop with two pointers and search each item just one time.

        So depending on whether the input string/array is sorted or not, the two pointer method can
        take O(nlogn) time complexity or better which is O(n)

    variants of two pointer
        Opposite directional : One pointer starts from the beginning while other pointer starts from
        the end. They move toward each other until they both meet or some condition is satisfied.

         Based on Oppsite directonal
        // Two sum II - input array is sorted
        // Valid palindrome
        // Move zeros
        // Reverse string
        // Remove element


        Equi directional: Both start from beginning, one slow runner and other fast runner

        Based on Equi directional
        // maximum sum of any contiguous sub array of size k
        // middle node of linkedlist
        // linkedlist cycle
        // longest substring without repeating characters
        // remove duplicates from sorted array

     */

    // Two sum II - input array is sorted
    public static void main(String[] args) {

        int arr[] = {2,7,11,15};

        int target = 9;

        System.out.println("Two sum using opp directional pointer: "+ Arrays.toString(twoSum(arr,target)));


    }

    private static int[] twoSum(int[] arr, int target) {

        int start = 0;
        int end = arr.length -1;
        int res[] = new int[2];
        while(start < end){
            int sum = arr[start] + arr[end];
            if(sum == target){
                res[0] = start + 1;
                res[1] = end + 1;
                break;
            }else if(sum > target){
                end--;
            }else{
                start++;
            }
        }
        return res;
    }
}
