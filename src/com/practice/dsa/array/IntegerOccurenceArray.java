package com.practice.dsa.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class IntegerOccurenceArray {

    public static void main(String[] args) {
        int arr[] = {1, 2, 2, 2, 2, 3, 4, 7 ,8 ,8 };
        int n = arr.length;
        int searchValue = 2;
        System.out.println("Integer occurences: " +countOccurrences(arr, n, searchValue));
        System.out.println("Integer occurences  using collections: " +countOccurrencesUsingCollection(arr,searchValue));
    }

    // using linear search
    private static int countOccurrences(int[] arr, int n, int searchValue) {
        int res  = 0;

        for(int i= 0;i<n;i++){
            if(searchValue == arr[i]){
                res++;
            }
        }
        return res;
    }

    // using binary search


    // using Collections
    static int countOccurrencesUsingCollection(int[] arr, int x) {
        List<Integer> arrList = IntStream.of(arr).boxed().collect(Collectors.toList());

        return Collections.frequency(arrList, x);
    }

}
