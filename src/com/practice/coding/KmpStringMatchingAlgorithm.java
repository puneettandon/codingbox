package com.practice.coding;

public class KmpStringMatchingAlgorithm {

    // https://www.youtube.com/watch?v=D6dCOa_gMoY&list=PLeIMaH7i8JDjd21ZF6jlRKtChLttls7BG&index=2
    public static void main(String[] args) {

        String text = "ABABDABACDABABCABAB";
        String pattern =  "ABABCABAB";

        String text1 = "AABAACAADAABAAABAA";
        String pattern1 = "AABA";

        naivePatternSearch(text1,pattern1);

        kmpPatternSearch(text,pattern);

    }

    private static void naivePatternSearch(String text, String pattern) {
        int textLength = text.length();
        int patternLength = pattern.length();
        int i,j;

        for(i = 0,j = patternLength -1; j < textLength;){
            if(pattern.equals(text.substring(i,j+1))){
                System.out.println("Pattern found at index: "+i);
            }
            i++;
            j++;
        }

    }

    private static void kmpPatternSearch(String text, String pattern) {

        int textLength = text.length();
        int patternLength = pattern.length();

        // create lps[] that will hold the longest
        // prefix suffix values for pattern
        int lps[] = new int[patternLength];

        int j = 0; // index for pat[]

        computeLPSArray(pattern,patternLength,lps);

        int i = 0;  // index for txt[]
        while(i < textLength){
            if(pattern.charAt(j) == text.charAt(i)){
                j++;
                i++;
            }
            if(j == patternLength) {
                System.out.println("Found Pattern at index " + (i - j));
                j = lps[j-1];
            }// mismatch after j matches
            else if(i < textLength && pattern.charAt(j) != text.charAt(i)){
                // Do not match lps[0..lps[j-1]] characters,
                // they will match anyway
                if (j != 0)
                    j = lps[j - 1];
                else
                    i = i + 1;
            }
        }
    }

    private static void computeLPSArray(String pattern, int patternLength, int[] lps) {
        // length of the previous longest prefix suffix
        int len = 0;
        int i = 1;
        lps[0] = 0; // // lps[0] is always 0

        // the loop calculates lps[i] for i = 1 to M-1
        while(i < patternLength){
            if(pattern.charAt(i) == pattern.charAt(len)){
                len++;
                lps[i] = len;
                i++;
            }else{   // (pat[i] != pat[len])
                // This is tricky. Consider the example.
                // AAACAAAA and i = 7. The idea is similar
                // to search step.
                if(len != 0){
                    len = lps[len -1];
                    //Also, note that we do not increment
                    //                    // i here
                }else{
                    lps[i]  = len;
                    i++;
                }
            }
        }
    }
}
