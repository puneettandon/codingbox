package com.practice.hackerrank.javaaidcodingprep;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PickingNumbers {

    // Problem Statement:  https://www.hackerrank.com/challenges/picking-numbers/problem
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        List<Integer> list = new ArrayList<>();
        while(n-- > 0 ){
            list.add(sc.nextInt());
        }

        int result = pickingNumbers(list);

        System.out.println("Pikcing Numbers Count: "+result);

    }

    private static int pickingNumbers(List<Integer> list) {

        int frequency[] = new int[101];
        int result = Integer.MIN_VALUE;

        for(int i = 0;i< list.size();i++){
            int index = list.get(i);
            frequency[index]++;
        }

        for(int i = 1;i<=100;i++){
            result = Math.max(result,frequency[i] + frequency[i-1]);
        }
        return result;
    }
}
