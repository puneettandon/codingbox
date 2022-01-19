package com.practice.coding;


import java.util.Arrays;

// Move all the zeros to end of the array
public class MoveZeroToEndOfArray {

    public static void main(String[] args) {

        int arr[] = {10,0,0,0,20,50,40};

        int newArr[] = new int[arr.length];

        rearrange(arr,newArr);
        print(newArr);
    }

    private static void print(int[] newArr) {
        System.out.println("Elements after adding zeros to end: ");
        for(int i : newArr){
            System.out.println(i);
        }
    }

    private static void rearrange(int[] arr, int[] newArr) {

        int j = 0;
        for(int i = 0;i<arr.length;i++){
            if(arr[i] != 0){
                newArr[j] = arr[i];
                j++;
            }
        }

    }

}
