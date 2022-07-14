package com.leetcode;

import java.util.ArrayList;
import java.util.List;

public class DuplicatesInArray {

    // https://leetcode.com/problems/find-all-duplicates-in-an-array/
    public static void main(String[] args) {

        int arr[] = {1,4,5,2,6,5,3,2};

        findDuplicates(arr);
    }

    private static void findDuplicates(int[] arr) {
        List<Integer> res = new ArrayList<>();
        for(int i = 0;i<arr.length;i++){
            int index = Math.abs(arr[i]) - 1;
            System.out.println("Index: "+index);
            if(arr[index] < 0 )
                res.add(Math.abs(arr[i]));
            arr[index] = -arr[index];
        }

        res.stream().forEach(e -> System.out.println(e));
    }
}
