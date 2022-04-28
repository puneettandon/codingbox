package com.practice.hackerrank.javaaidcodingprep;

import java.util.Scanner;

public class Staircase {

    // Problem Statement: https://www.hackerrank.com/challenges/staircase/problem
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
       // staircase(n);
        staircaseOptimized(n);
        sc.close();
    }

    private static void staircase(int n) {
        for (int i = 0; i <= n; i++) {
            for (int j = 1; j <= n - i; j++) {
                System.out.print(" ");
            }
            for (int k = 1; k <= i; k++) {
                System.out.print("#");
            }
            System.out.println();
        }
    }

        private static void staircaseOptimized(int n){
            String str = "#";
            for(int i = 0;i<n;i++){
                System.out.printf("%"+n+"s\n",str);
                str += "#";
            }
        }
}
