package com.practice.coding;

public class NumberPalindrome {

    public static void main(String[] args) {

        int num = 2002;

        if(isNumberPalindrome(num) != -1)
            System.out.println(num+" is Palindrome");
        else
            System.out.println(num+ " is not Palindrome");

        System.out.println(num + " is num palindrome using String  " + isNumberPalindromeUsingString(num));

        System.out.println(num + " is num palindrome using StringBuilder reverse " + isNumberPalindromeUsingStringBuilderReverse(num));
    }

    private static int isNumberPalindrome(int num) {

        if(num < 0 )
            num = (-num);

        int dupNum = (num);

        return  isPalindromeUtil(num,dupNum);
    }

    private static int isPalindromeUtil(int num, int dupNum) {

        if(num == 0){
            return dupNum;
        }else{
            dupNum = isPalindromeUtil(num/10,dupNum);
        }
        if(num % 10 == dupNum %10){
            return dupNum / 10 ;
        }else{
           return -1;
        }
    }


    private static boolean isNumberPalindromeUsingString(int num) {

        String strNum = String.valueOf(num);
        int len = strNum.length();

        for(int i = 0; i<len/2;i++){
            if(strNum.charAt(i) != strNum.charAt(len-i-1))
                return false;
        }
        return true;
    }

    private static boolean isNumberPalindromeUsingStringBuilderReverse(int num) {

        String strNum = String.valueOf(num);

        String str = new StringBuilder(strNum).reverse().toString();

        return str.equals(strNum);
    }



}
