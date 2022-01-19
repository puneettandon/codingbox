package com.practice.coding;

// panagram - string contains all 26 characters
public class Panagram {

    public static void main(String[] args) {

        String str1 = "The quick brown fox jumps over the lazy dog";
        String str = "hello world";
        System.out.println(str + "is panagram : " +isPanagram(str.toLowerCase()));

        System.out.println(str + "is panagram : " +isPanagramV2(str));

    }

    private static boolean isPanagram(String str) {
        if(str.length() < 26)
            return  false;
        else{
            for(char ch='a'; ch <= 'z'; ch++){
                if(str.indexOf(ch) < 0)
                    return  false;
            }
        }
        return  true;
    }

    private  static  boolean isPanagramV2(String str){

        boolean[] mark = new boolean[26];

        int index = 0;

        for(int i = 0;i< str.length();i++){
            if('A' <= str.charAt(i) && str.charAt(i) <= 'Z')
                index = str.charAt(i) - 'A';
            else if('a' <= str.charAt(i) && str.charAt(i) <= 'z')
                index = str.charAt(i) - 'a';
            else
                continue;
            mark[index] = true;
        }

        for(int i = 0; i<=25; i++){
            if(mark[i] == false)
                return  false;
        }
        return true;
    }
}
