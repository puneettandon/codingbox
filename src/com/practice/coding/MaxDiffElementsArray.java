package com.practice.coding;

import java.util.Scanner;

/// to get the maximum difference between elements in array
public class MaxDiffElementsArray {

    public static void main(String[] args) {

        int n,max,min;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of elements");
        n = sc.nextInt();
        int a[] = new int[n];
        System.out.println("Enter the elements of array");
        for(int i = 0;i<n;i++){
            a[i] = sc.nextInt();
        }

        // find max
        max = a[0];
        min = a[0];
        for(int i= 0;i<n; i++){
            if(a[i] > max){
                max = a[i];
            }
        }

        for(int i= 0;i<n; i++){
            if(a[i] < min){
                min = a[i];
            }
        }

        System.out.println("Maximum = "+ max );
        System.out.println("Minimum = "+ min);
        System.out.println("Max difference b/w elements: "+ (max -min));

        // practice max difference b/w elements
        System.out.println("Max difference b/w elements Practice : "+ maxDifferenceElementsArray(a));
    }

    private static int maxDifferenceElementsArray(int[] a) {
        int min = a[0];
        int max = a[0];

        for(int i =0 ;i< a.length;i++){
            if(a[i]> max){
                max = a[i];
            }
            if(a[i]< min){
                min = a[i];
            }
        }
        return max -min;
    }
}
