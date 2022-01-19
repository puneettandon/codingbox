package com.practice.coding;

// find the number of occurences of a character
public class OccurencesOfCharacter {

    public static void main(String[] args) {

        String str = "Hello World";
        String charOccurence = "l";

        System.out.println("occurence of char = " + charOccurence + " is : " +findOccurencesOfCharacter(str,charOccurence));
    }

    private static int findOccurencesOfCharacter(String str, String charOccurence) {

        String strWithoutChar = str.replace(charOccurence,"");
        int initialLength = str.length();
        int finalLength = strWithoutChar.length();

        return initialLength - finalLength;
    }
}
