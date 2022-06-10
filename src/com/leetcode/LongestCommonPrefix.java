package com.leetcode;

public class LongestCommonPrefix {

    // https://www.youtube.com/watch?v=fhyIORFDD0k
    //
    public static void main(String[] args) {

        String str1 = "flower";
        String str2 = "slow";
        String str3 = "wlight";

        System.out.println("The longest common prefix " + findLongestCommonPrefix(str1, str2, str3));

    }

    private static String findLongestCommonPrefix(String str1, String str2, String str3) {

        int n1 = str1.length();
        int n2 = str2.length();
        int n3 = str3.length();

        int count = 0;
        String res = "";

        int min = Math.min(Math.min(n1, n2), n3);
        for (int i = 0; i < min; i++) {
            char ch1 = str1.charAt(i);
            char ch2 = str2.charAt(i);
            char ch3 = str3.charAt(i);
            if ((ch1 == ch2) && (ch2 == ch3)) {
                count++;
                res += ch1;
            }else {
                break;
            }
        }

        return res;
    }

}
