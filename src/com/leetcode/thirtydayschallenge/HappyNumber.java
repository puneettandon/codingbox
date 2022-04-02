package com.leetcode.thirtydayschallenge;

import java.util.HashSet;
import java.util.Set;

public class HappyNumber {

    // https://leetcode.com/problems/happy-number/
    public static void main(String[] args) {

        Set<Integer> mySet = new HashSet<>();
        int num = 29;
        int r;
        int val;
        int temp = num;

        while(true){
            val = 0;
            while( temp > 0){
               r = temp % 10;
               val = val + r *r;
               temp = temp/10;
            }
            if( val == 1){
                System.out.println("Number: "+num+ " is happy number");
                break;
            }else if(!mySet.contains(val)){
                mySet.add(val);
                temp = val;
            }else if(mySet.contains(val)){
                System.out.println("It's not the happy number");
                break;
            }
        }

    }
}
