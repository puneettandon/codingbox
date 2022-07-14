package com.leetcode;

public class DetectCapital {

    // https://leetcode.com/problems/detect-capital/
    public static void main(String[] args) {
        String word = "Leetcode";

        System.out.println("Is capital right: "+detectCapitalUse(word));
    }

    private static boolean detectCapitalUse(String word) {

        if(word.length() == 0)
            return true;
        int count = 0;
        int len = word.length();
        for(int i = 0;i<len;i++){
            int ch = word.charAt(i);
            if(Character.isUpperCase(ch)){
                count++;
            }
        }
        if(count == len) return true;
        if(count == 0) return true;
        if(count == 1 && Character.isUpperCase(word.charAt(0))) return true;
        return false;
    }

}
