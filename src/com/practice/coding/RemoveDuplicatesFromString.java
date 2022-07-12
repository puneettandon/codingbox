package com.practice.coding;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class RemoveDuplicatesFromString {

    public static void main(String[] args) {

        String str = "puneettandon";

        String output = removeDuplicatesFromString(str);
        System.out.println("original string: "+ str + " \nafter removing duplicate characters : "+ output);

    //    System.out.println("original string: "+ str + " \nafter removing duplicate characters using sorting : "+ removeDuplicatesFromStringBySorting(str));

        System.out.println("original string: "+ str + " \nafter removing duplicate characters using index of : "+ removeDuplicatesFromStringUsingIndexOf(str));

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



    private static String removeDuplicatesFromStringUsingIndexOf(String s) {

        int len = s.length();
        String str = new String();

        for(int i = 0;i<len;i++){
            char c = s.charAt(i);

            if(str.indexOf(c) < 0 ){
                str  += c;
            }
        }
        return str;
    }

}
