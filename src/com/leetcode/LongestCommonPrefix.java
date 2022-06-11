package com.leetcode;

public class LongestCommonPrefix {

    // https://www.youtube.com/watch?v=fhyIORFDD0k
    //
    public static void main(String[] args) {

        String str1 = "slower";
        String str2 = "slow";
        String str3 = "slight";

        System.out.println("The longest common prefix " + findLongestCommonPrefix(str1, str2, str3));

        // Longest common prefix using word by word matching
        String arr[] = {"geeksforgeeks", "geeks",
                "geek", "geezer"};
        int n = arr.length;
        System.out.println("Longest common prefix using word by word matching: "+findLongestCommonPrefixUsingWordMatching(arr,n));

    }

    private static String findLongestCommonPrefixUsingWordMatching(String[] arr, int n) {

        String prefix = arr[0];
        for(int i = 1;i<=n-1;i++){
            prefix = findLongestCommonPrefixUsingWordMatchingUtil(prefix,arr[i]);
        }
        return prefix;
    }

    private static String findLongestCommonPrefixUsingWordMatchingUtil(String str1, String str2) {

        String result = "";
        int n1 = str1.length();
        int n2 = str2.length();

        for(int i = 0,j=0 ;i<=n1-1 && j<=n2-1; i++,j++){
            if(str1.charAt(i) != str2.charAt(j))
                break;
            result += str1.charAt(i);
        }
        return result;
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
