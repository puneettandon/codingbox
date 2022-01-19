package com.practice.coding;

public class FirstLetterEachWord {

    public static void main(String[] args) {

        String str = "world is full of opportunities";

        String[] strArray = str.split(" ");

        for(int i = 0;i< strArray.length;i++){
            System.out.println(strArray[i].charAt(0));
        }
    }
}
