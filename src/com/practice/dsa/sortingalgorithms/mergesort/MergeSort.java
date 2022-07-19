package com.practice.dsa.sortingalgorithms.mergesort;

import java.util.Arrays;

public class MergeSort {

    public static void main(String[] args) {

        int a[] = {2,8,15,18};
        int b[] = {5,9,12,17,19,20,21};

        int m = a.length;
        int n = b.length;


     //   mergeV1(a,b,m,n);

        int arr[] = {2,8,4,7,3,5};
        mergeSortV1(arr,0,arr.length-1);
        Arrays.stream(arr).forEach(System.out::println);
    }

    private static void mergeSortV1(int[] arr, int l, int r) {
        if(l < r){
            int m = l + (r-l)/2;
            mergeSortV1(arr,l,m);
            mergeSortV1(arr,m+1,r);

            merge(arr,l,m,r);
        }
    }

    private static void merge(int[] arr, int l, int m, int r) {
        int n1 = m - l + 1;
        int n2 = r - m;

        int L[] = new int[n1];
        int R[] = new int[n2];

        for (int i = 0; i < n1; ++i)
            L[i] = arr[l + i];
        for (int j = 0; j < n2; ++j)
            R[j] = arr[m + 1 + j];

        int i = 0, j = 0;

        int k = l;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            }
            else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }


        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }

        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }


    private static void mergeV1(int[] a, int[] b, int m, int n) {
        int i = 0, j = 0, k =0;

        int c[] = new int[m+n];
        while(i<m  && j<n) {
            if (a[i] < b[j]) {
                c[k] = a[i];
                k++;
                i++;
            } else {
                c[k] = b[j];
                k++;
                j++;
            }
        }
        for(;i<m;i++){
            c[k] = a[i];
            k++;
        }
        for(;j<n;j++){
            c[k] = b[j];
            k++;
        }
        Arrays.stream(c).forEach(System.out::println);
    }
}
