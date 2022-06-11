package com.leetcode;

import java.util.ArrayList;

public class LetterCombinationsPhoneNumber {

    public static void main(String[] args) {

        String num = "23";

        getLetterCombinationsOfPhoneNumber(num);

    }

    private static void getLetterCombinationsOfPhoneNumber(String num) {

        letterCombinations(num);
    }

    private static void letterCombinations(String num) {

        String[] table = {
                "0","1","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"
        };

        ArrayList<String> list = letterCombinationsUtil(num,table);
        makeCombinations(list);

    }

    private static void makeCombinations(ArrayList<String> list) {

        list.forEach(  e -> {
            
        });
    }

    private static ArrayList<String> letterCombinationsUtil(String num, String[] table) {

        ArrayList<String> list = new ArrayList<>();

        for(int i =0;i<num.length();i++){
            char ch = num.charAt(i);
            String str = table[Character.getNumericValue(ch)];
            list.add(str);
        }
        list.forEach( e -> System.out.println(e));
        return list;
    }
}
