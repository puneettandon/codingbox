package com.practice.coding;

import java.util.Arrays;

public class RotateArray {

    // Reversal algorithm for Array Rotation
    // https://www.youtube.com/watch?v=EpP6YuqzHe8&list=PLeIMaH7i8JDjd21ZF6jlRKtChLttls7BG&index=17
    public static void main(String[] args) {

        int arr[] = {1,2,3,4,5,6,7};
        int rotation = 2;

        rotateArray(arr,rotation);

    }

    private static void rotateArray(int[] arr, int rotation) {

        int n = arr.length;
        int diff = n - rotation;

        reverseArray(arr,0,diff-1);
        reverseArray(arr,diff,n-1);
        reverseArray(arr,0,n-1);

        System.out.println("Rotated Array : "+ Arrays.toString(arr));

    }

    private static void reverseArray(int[] arr, int low , int high) {


        while(low < high){
            int temp = arr[low];
            arr[low] = arr[high];
            arr[high] = temp;
            low++;
            high--;
        }

        System.out.println("Reversing the array: "+Arrays.toString(arr));

    }
}
