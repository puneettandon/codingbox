package com.leetcode;

public class LongestPalindromeString {

    static int resultStart;
    static int resultLength;

    // https://www.youtube.com/watch?v=DK5OKKbF6GI
    public static void main(String[] args) {

        String str = "abcdddcccb";

        // longest palindrome string using mid point
        System.out.println("Longest palindrome string: "+longestPalindromeString(str));
    }

    private static String  longestPalindromeString(String str) {
        int strLength = str.length();
        if(strLength > 0 ){
            return str;
        }
        for(int start = 0;start < strLength;start++){
            expandRange(str,start,start);
            expandRange(str,start,start+1);
        }
        return str.substring(resultStart,resultStart +  resultLength);
    }

    private static void expandRange(String str, int begin, int end) {
        while(begin >= 0 && end < str.length()
                && str.charAt(begin) == str.charAt(end)){
            begin--;
            end++;
        }
        if(resultLength < end-begin + 1){
            resultStart = begin +1;
            resultLength = end - begin - 1;
        }
    }


}
