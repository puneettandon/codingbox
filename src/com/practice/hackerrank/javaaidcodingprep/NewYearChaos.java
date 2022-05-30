package com.practice.hackerrank.javaaidcodingprep;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//Problem Statement :  https://www.hackerrank.com/challenges/new-year-chaos/problem
public class NewYearChaos {

    public static void main(String[] args) {

        Integer[] arr = new Integer[]{1,2,5,3,7,8,6,4};  // 2 + 2 + 2 + 1
        //  1,2,3,4,5,6,7,8
        //  1,2,3,4,5,6,8,7
        //
        List<Integer> integerList =  Arrays.asList(arr);
        System.out.println("Minimum bribes = : " + minimumBribes(integerList));

    }

    private static int minimumBribes(List<Integer> integerList) {
        int swapCount = 0;
        int position = 0;
        for (Integer integer : integerList) {
            System.out.println("Diff : "+(integer - (position+1)));
            if(integer != position+1){
                if(integer - (position+1) == 1){
                    swapCount++;
                }else if(integer - (position+1) == 2){
                    swapCount = swapCount + 2;
                }else if(integer -(position+1) < 0){
                    position++;
                    continue;
                }else if(integer-(position+1) > 2){
                    System.out.println("Too Chaotic");
                    break;
                }
            }
            position++;
        }
        return swapCount;
    }
}
