package com.practice.coding;

import java.util.Scanner;

public class StringPalindrome {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String original = sc.nextLine();

        boolean isPalindrome = checkPalindrome(original);
        System.out.println("Is Given String : "+ original + " pallindrome : "+isPalindrome);

        System.out.println(original + " is palindrome : "+checkPalindromeStartEnd(original));
    }

    private static boolean checkPalindrome(String original) {
        String reverse = "";

        for(int i = original.length()-1 ; i>=0;i--){
            reverse = reverse + original.charAt(i);
        }
        if(reverse.equals(original))
            return true;
        else
            return false;
    }

    private static boolean checkPalindromeStartEnd(String str){

        int len = str.length();
        for(int i = 0;i<len/2;i++){
            if(str.charAt(i) != str.charAt(len-i-1))
                return false;
        }
        return true;
    }
}
