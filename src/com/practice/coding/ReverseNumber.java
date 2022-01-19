package com.practice.coding;

public class ReverseNumber {

    public static void main(String[] args) {
        Integer number= 123;

        String numStr = String.valueOf(number);
        String reverse = "";
        for(int i = numStr.length()-1; i >= 0;i--){
            reverse = reverse + numStr.charAt(i);
        }

        System.out.println("Reverse number is "+ Integer.valueOf(reverse));
    }
}
