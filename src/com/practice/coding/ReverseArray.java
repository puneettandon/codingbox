package com.practice.coding;

public class ReverseArray {

    public static void main(String[] args) {
        int arr[] = {10,20,30,40};

        int low = 0, high = arr.length -1;

        while(low < high){
            int temp = arr[low];
            arr[low] = arr[high];
            arr[high] = temp;
            low++;
            high--;
        }

        for(int i : arr) {
            System.out.println(i);
        }
    }
}
