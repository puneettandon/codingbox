package com.practice.coding;

public class VowelAndConsonants {

    public static void main(String[] args) {

        String str = "learn with youtube";

        findVowelAndConsonants(str);
    }

    private static void findVowelAndConsonants(String str) {

        int vowelCount = 0;
        int consonantCount = 0;

        for(int i = 0;i< str.length();i++){
            if(isVowel(str.charAt(i))){
                ++vowelCount;
            }else{
                ++consonantCount;
            }
        }
        System.out.println("Vowel count = "+vowelCount);
        System.out.println("Consonant count = "+consonantCount);
    }

    private static boolean isVowel(char ch) {
        if(ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U' ||
                ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u' )
            return  true;
        else
            return false;
    }
}
