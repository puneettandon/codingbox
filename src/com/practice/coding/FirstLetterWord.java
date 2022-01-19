package com.practice.coding;

// print  first letter of each word in a string
public class FirstLetterWord {

    public static void main(String[] args) {

        String str = "Learn with youtube";

        printFirstLetterWord(str);

    }

    private static void printFirstLetterWord(String str) {

        String words[] = str.split(" ");

        for(int i = 0; i< words.length;i++){
            System.out.print(words[i].charAt(0));
        }
    }
}






