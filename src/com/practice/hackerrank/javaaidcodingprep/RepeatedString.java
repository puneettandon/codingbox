package com.practice.hackerrank.javaaidcodingprep;

// problem Statement Link : https://www.hackerrank.com/challenges/repeated-string/problem

import java.util.Scanner;

public class RepeatedString {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        long n = sc.nextLong();
        long charCount = repeatedString(s,n);
        System.out.println("Char count in string : "+s + " of frequency "+ n + " is "+ charCount);
        sc.close();
    }

    private static long repeatedString(String str, long n) {

        int strLength = str.length();
        long q = 0, r = 0;
        q = n / strLength;
        r = n % strLength;
        long partialStrLen = (r==0) ? 0 : r;
        long charCount = q * getLetterCount(str,strLength) + getLetterCount(str,partialStrLen);
        return charCount;

    }

    private static long getLetterCount(String str, long strLength) {
        long count = 0;
        for(int i = 0;i<strLength;i++){
            if(str.charAt(i) == 'a'){
                count++;
            }
        }
        return count;
    }
}
