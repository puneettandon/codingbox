package com.practice.coding;

import java.util.Arrays;

public class RotateArray {

    // Reversal algorithm for Array Rotation
    // https://www.youtube.com/watch?v=EpP6YuqzHe8&list=PLeIMaH7i8JDjd21ZF6jlRKtChLttls7BG&index=17
    public static void main(String[] args) {

        int arr[] = {1,2,3,4,5,6,7};
        int rotation = 2;

        rotateArray(arr,rotation);

        rotateLeft(arr,2);

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

    private static void rotateLeft(int[] arr, int d) {
        int n = arr.length;
        d = d % n;

        int i,j,k,temp;

        int gcd = gcd(d,n);
        System.out.println("gcd: "+gcd);

        for(i = 0;i<gcd ;i++){
            temp = arr[i];
            j = i;
            while(true){
                k = j + d;
                if(k >= n )
                    k = k - n;
                if(k == i)
                    break;
                arr[j] = arr[k];
                j = k;
             }
            arr[j] = temp;
        }

    }

    private static int gcd(int a, int b) {

        if(b == 0)
            return a;
        else
            return  gcd(b,a % b);
    }
}
