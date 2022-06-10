package com.practice.hackerrank.javaaidcodingprep;

import java.util.Arrays;

// https://www.youtube.com/watch?v=sSno9rV8Rhg
// https://www.youtube.com/watch?v=DuikFLPt8WQ&list=PLSIpQf0NbcCm1HjcbM6aAoDUdpZyS1YBP&index=11
public class LongestCommonSubSequence {

    public static void main(String[] args) {

        String str1 = "bd";
        String str2 = "abcd";

        int n1 = str1.length();
        int n2 = str2.length();

        // using recursion
        System.out.println("Length of longest common sub sequence using recursion : "+longestCommonSubSequenceRecursion(str1,str2,n1,n2));


        // using dynamic programming memoization
        int maximum = 1000;
        int dp[][] = new int[n1][maximum];

        for(int[] row : dp){
            Arrays.fill(row,-1);
        }

        System.out.println("Length of longest common sub sequence using dynamic programming: "
                +longestCommonSubSequenceDP(str1,str2,n1,n2,dp));


    }


    private static int longestCommonSubSequenceRecursion(String str1, String str2, int n1, int n2) {

        if(n1 == 0 || n2 == 0)
            return 0;
        if(str1.charAt(n1-1) == str2.charAt(n2-1)){
            return 1 + longestCommonSubSequenceRecursion(str1,str2,n1-1,n2-1);
        }else{
            return Math.max(longestCommonSubSequenceRecursion(str1,str2,n1,n2-1),
                    longestCommonSubSequenceRecursion(str1,str2,n1-1,n2));
        }
    }

    private static int longestCommonSubSequenceDP(String str1, String str2, int n1, int n2, int[][] dp) {

        if(n1 == 0 || n2 == 0){
            return 0;
        }

        if(dp[n1-1][n2-2] != -1 ){
            return dp[n1-1][n2-1];
        }

        if(str1.charAt(n1-1) == str2.charAt(n2-1)){
            dp[n1-1][n2-1] = 1 + longestCommonSubSequenceDP(str1,str2,n1-1,n2-1,dp);
            return dp[n1-1][n2-1];
        }else{
            dp[n1-1][n2-1] = Math.max(
                    longestCommonSubSequenceDP(str1,str2,n1,n2-1,dp),
                    longestCommonSubSequenceDP(str1,str2,n1-1,n2,dp)
            );
            return dp[n1-1][n2-1];
        }
    }
}
