package com.practice.coding;

public class ReverseWordsInString {

    public static void main(String[] args) {

        String str = "Welcome to java world";

        String strArr[] = str.split(" ");

        for(int i = strArr.length -1 ; i>= 0;i--){
            System.out.print(strArr[i] + " ");
        }
    }
}
