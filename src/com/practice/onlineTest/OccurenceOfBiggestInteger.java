package com.practice.onlineTest;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class OccurenceOfBiggestInteger {

    public static void main(String[] args) {
        int arr[] = {3,1,4,1,5};

       int res =  maxOccurenceOfBiggestInteger(arr);

        System.out.println("Max Occurence of biggest integer : "+res);
    }

    private static int maxOccurenceOfBiggestInteger(int[] arr) {

        Map<Integer,Integer> hm = new HashMap<>();

        for(int i = 0;i<arr.length;i++){
            if(!hm.containsKey(arr[i])){
                hm.put(arr[i],1);
            }else{
                hm.put(arr[i],hm.get(arr[i])+1);
            }
        }

        int maxLargest = 0;

        for (Map.Entry<Integer, Integer> entry : hm.entrySet()) {
            int largestKey = entry.getKey();
            int largestValue = entry.getValue();
            if(largestKey == largestValue && largestKey > maxLargest){
                maxLargest = largestKey;
            }
        }

        return maxLargest;
    }
}
