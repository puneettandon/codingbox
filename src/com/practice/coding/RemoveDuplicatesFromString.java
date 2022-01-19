package com.practice.coding;

import java.util.HashSet;
import java.util.Set;

public class RemoveDuplicatesFromString {

    public static void main(String[] args) {

        String str = "puneettandon";

        String output = removeDuplicatesFromString(str);
        System.out.println("original string: "+ str + " \nafter removing duplicate characters : "+ output);
    }

    private static String removeDuplicatesFromString(String str) {

        Set<Character> set = new HashSet<>();
        StringBuffer sb = new StringBuffer();

        for(int i = 0; i< str.length();i++){
            char c = str.charAt(i);
            if(!set.contains(c)){
                set.add(c);
                sb.append(c);
            }
        }
        return  sb.toString();
    }
}
