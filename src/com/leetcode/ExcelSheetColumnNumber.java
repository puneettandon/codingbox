package com.leetcode;

public class ExcelSheetColumnNumber {

    // https://leetcode.com/problems/excel-sheet-column-number/
    public static void main(String[] args) {
        String s = "AB";
        System.out.println("Excel sheet to number: "+titleToNumber(s));
    }

    private static int titleToNumber(String s) {
        int ans = 0;
        int p = 0;

        for(int i = s.length() -1 ;i>=0;i--){
            char c = s.charAt(i);
            int val = (int)c -65 + 1;
            System.out.println("char  : "+(int)c);
            System.out.println("Val : "+val);
            ans += val * Math.pow(26,p);
            p++;
        }
        return ans;
    }
}
