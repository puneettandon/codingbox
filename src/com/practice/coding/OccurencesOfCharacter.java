package com.practice.coding;

// find the number of occurences of a character
public class OccurencesOfCharacter {

    public static void main(String[] args) {

        String str = "Hello World";
        String charOccurence = "l";

        System.out.println("occurence of char = " + charOccurence + " is : " +findOccurencesOfCharacter(str,charOccurence));
        System.out.println("occurence of char Practice1 = " + charOccurence + " is : " + findOccurrencesOfCharacterPractice1(str,charOccurence));
    }

    private static int findOccurencesOfCharacter(String str, String charOccurence) {

        String strWithoutChar = str.replace(charOccurence,"");
        int initialLength = str.length();
        int finalLength = strWithoutChar.length();

        return initialLength - finalLength;
    }

    private static int findOccurrencesOfCharacterPractice1(String str, String charOccurrence){
        int count = 0;
        for(int i = 0;i<str.length();i++){
            String value = String.valueOf(str.charAt(i));
            if(value.equals(charOccurrence)){
                count++;
            }
        }
        return count;
    }




}
