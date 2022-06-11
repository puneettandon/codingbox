package com.leetcode;

import java.util.Arrays;

public class RemoveDuplicateFromArray {


    // https://www.youtube.com/watch?v=gf7vdIin0dk
    // Remove duplicate elements from array
    public static void main(String[] args) {

        int arr[] = {1,2,2,3,3,4,4,4,5,5};

        // using extra space
        removeDuplicatesFromArrayUsingExtraSpace(arr);

        System.out.println();

        // using constant space
        removeDuplicatesFromArrayUsingConstantSpace(arr);


    }

    // O(n) - extra space
    private static void removeDuplicatesFromArrayUsingExtraSpace(int[] arr) {

        System.out.println("Remove duplicates from array Using Extra space before removing:  "+ Arrays.toString(arr));
         int j = 0;
         int n = arr.length;
         int temp[] = new int[n];
         for(int i = 0;i< n -1;i++){
             if(arr[i] != arr[i+1])
             {
                 temp[j]= arr[i];
                 j++;
             }
         }
         temp[j] = arr[n-1];

        System.out.println("Remove duplicates from array Using Extra space after removing:  "+ Arrays.toString(temp));
    }

    // O(1) - no extra space
    private static void removeDuplicatesFromArrayUsingConstantSpace(int[] arr) {

        System.out.println("Remove duplicates from array Using Constant space before removing:  "+ Arrays.toString(arr));
        int j = 0;
        int n = arr.length;

        for(int i = 0;i<n -1;i++){
            if(arr[i]!= arr[i+1]){
                arr[j] = arr[i];
                j++;
            }
        }
        arr[j] = arr[n-1];

        System.out.println("Remove duplicates from array Using Constant space after removing:  "+ Arrays.toString(arr));

    }
}
