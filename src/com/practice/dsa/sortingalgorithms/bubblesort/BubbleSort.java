package com.practice.dsa.sortingalgorithms.bubblesort;

import java.util.Arrays;

// bubble sort can be made adaptive by adding flag
// bubble sort is stable as order will not change in case of duplicate elements (it will interchange only if it is greater)
public class BubbleSort {

    public static void main(String[] args) {

        int arr[] = {8,5,7,3,2,6,1};
        int len = arr.length;

        bubbleSortV1(arr,len);
    }

    private static void bubbleSortV1(int[] arr, int len) {

        int flag;

        for(int i = 0; i< len-1;i++){
            flag = 0;
            for(int j = 0; j<len -1-i;j++){
                if(arr[j]>arr[j+1]){
                    swap(j,j+1,arr);
                    flag = 1;
                }
            }
            if(flag == 0) break;
        }
        Arrays.stream(arr).forEach(System.out::println);
    }

    private static void swap(int index1, int index2,int[] arr) {
        int temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }
}
