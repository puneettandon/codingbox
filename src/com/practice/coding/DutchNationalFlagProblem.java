package com.practice.coding;

import java.util.Arrays;
import java.util.Collections;

public class DutchNationalFlagProblem {


    // segregate  0s, 1s ,2s together
    public static void main(String[] args) {

        int arr[] = {0,1,1,0,1,2,1,2,0,0,0,1};

       segregate012together(arr);

    }


    // O(n)
    private static void segregate012together(int[] arr) {

        int n = arr.length;
        int low = 0;
        int high = n - 1;
        int mid = 0;

        while(mid <= high){
            switch (arr[mid]){
                case 0:
                    arr[mid] = swap(arr[low],arr[low] = arr[mid] );
                    low++;
                    mid++;
                    break;
                case 1:
                    mid++;
                    break;
                case 2:
                    arr[high] = swap(arr[mid],arr[mid] = arr[high]);
                    high--;
                    break;
            }
        }

        System.out.println("Segregate 0s 1s 2s together: "+ Arrays.toString(arr));
    }

    private static int swap(int i, int j) {
       return i;
    }
}
