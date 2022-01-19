package com.practice.coding;

import java.util.Arrays;

public class BottleCaps {

    public static void main(String[] args) {

        String input = "8B,9C,3B,8C,9B";
        int count = 0;

        String arr[] = input.split(",");

        System.out.println(Arrays.toString(arr));

        for(int i = 0;i<arr.length;i++){

            for(int j = i+1;j<=i+3;j++) {
                if (i < arr.length && j < arr.length ){
                    if (arr[i].charAt(1) != arr[j].charAt(1)) {
                        if (arr[i].charAt(0) == arr[j].charAt(0)) {
                            count++;
                        }
                    }
            }
            }
        }
        System.out.println("Count = "+count);
    }
}
