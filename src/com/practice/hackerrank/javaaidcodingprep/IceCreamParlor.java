package com.practice.hackerrank.javaaidcodingprep;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class IceCreamParlor {

    //https://www.hackerrank.com/challenges/icecream-parlor/problem
    public static void main(String[] args) {

        int sum = 8;
        int arr[] = {1,4,5,3,2};

        int result1[] = iceCreamParlorA1(sum,arr);
        System.out.println("Number using hashmap approach : "+ result1[0] + " , "+ result1[1]);

        int result2[] = iceCreamParlorA2(sum,arr);
        System.out.println("Number using Array approach : "+ result2[0] + " , "+ result2[1]);

        int result3[] = iceCreamParlorA3(sum,arr);
        System.out.println("Number using Editorial approach : "+ result3[0] + " , "+ result3[1]);



    }

    // Approach1 using HashMap
    private static int[] iceCreamParlorA1(int sum, int[] arr) {
        int result[] = new int[2];
        Map<Integer,Integer> map = new HashMap<>();
        for(int i = 0;i<arr.length;i++){
            int x = arr[i];
            int y = sum - x;
            Integer j = map.get(y);
            if(j != null){
                result[0] = j + 1;
                result[1] = i + 1;
                break;
            }else{
                map.put(x,i);
            }
        }
        return result;
    }


    // Approach using Array
    private static int[] iceCreamParlorA2(int sum, int[] arr) {
        int result[] = new int[2];
        int n = arr.length;
        int frequency[] = new int[10001];

        Arrays.fill(frequency,-1);

        for(int i = 0;i< arr.length;i++){
            int x = arr[i];
            int y = sum - x;

            if(y > 0){
                int j = frequency[y];

                if(j != -1){
                    result[0] = j + 1;
                    result[1] = i + 1;
                    break;
                }
            }
            frequency[x] = i ;
        }
        return  result;
    }

    private static int[] iceCreamParlorA3(int sum, int[] arr) {
        return null;
    }

}
