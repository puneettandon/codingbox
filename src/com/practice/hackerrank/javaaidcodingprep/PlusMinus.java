package com.practice.hackerrank.javaaidcodingprep;

import java.util.Scanner;

public class PlusMinus {

    // Problem Statement - https://www.hackerrank.com/challenges/plus-minus/problem
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        for(int i = 0;i<n;i++){
            arr[i] = in.nextInt();
        }
        plusMinus(arr);
        in.close();


    }

    private static void plusMinus(int[] arr) {
        int len = arr.length;
        float positiveCount = 0;
        float negativeCount = 0;
        float zeroCount = 0;
        for(int i = 0;i<len;i++){
            int element = arr[i];
            if(element > 0)
                positiveCount++;
            else if(element < 0)
                negativeCount++;
            else
                zeroCount++;

        }

        System.out.printf("%1.6f\n",positiveCount/len);
        System.out.printf("%1.6f\n",negativeCount/len);
        System.out.printf("%1.6f\n",zeroCount/len);
    }
}
