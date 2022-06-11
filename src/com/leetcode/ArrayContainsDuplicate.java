package com.leetcode;

import java.util.HashSet;
import java.util.Set;

public class ArrayContainsDuplicate {

    // Approach 1 - using brute force - time complexity - O(n^2)  - Space complexity - O(1)
    // Appraoch 2 - using sorting - time complexity - O(nlogn) - Space complexity - O(1)
    // Approach 3 - using hashset but will increase space complexity
    public static void main(String[] args) {
        int arr[] = {1,2,3,1};

        System.out.println("Contains Duplicate: "+ containsDuplicate(arr));

    }

    private static boolean containsDuplicate(int[] arr) {

        Set set = new HashSet();

        for(int i = 0;i<arr.length;i++){
            if(set.contains(arr[i])){
                return true;
            }else{
                set.add(arr[i]);
            }
        }
        return false;
    }
}
