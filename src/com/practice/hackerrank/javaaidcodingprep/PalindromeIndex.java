package com.practice.hackerrank.javaaidcodingprep;

public class PalindromeIndex {

    // problem statement : https://www.hackerrank.com/challenges/palindrome-index/problem
    public static void main(String[] args) {

        String str = "abcca";
        int res = palindromeIndex(str);

        if(res == -1)
            System.out.println("Already Palindrome");
        else
            System.out.println("Need to remove character at : "+res+ " to make string : "+ str +" palindrome");

    }

    private static int palindromeIndex(String str) {

        int palindromeIndex = -1;
        int len = str.length();

        for(int i = 0;i<len/2;i++){
            if(str.charAt(i) != str.charAt(len -i -1)){
                if(i + 1 < len){
                    boolean isRightStringValidPalindrome = isValidPalindrome(str.substring(i+1,len-i));
                    if(isRightStringValidPalindrome)
                        return i;
                    return len -i -1;
                }
            }
        }
        return palindromeIndex;
    }

    private static boolean isValidPalindrome(String str) {
        int len = str.length();
        for(int i = 0;i< len/2;i++){
            if(str.charAt(i) != str.charAt(len -i -1)){
                return false;
            }
        }
        return true;
    }
}
