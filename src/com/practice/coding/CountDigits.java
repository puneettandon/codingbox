package com.practice.coding;

public class CountDigits {

    public static void main(String[] args) {

        int num = 534;
        int count = 0;

        // iteratively
        while(num > 0){
            num = num /10;
            count++;
        }

        System.out.println("Iteratively digit count: " +count);

        // recursively
        int number= 534;
        System.out.println("Recursively digit count: "+countDigitsRec(number));
    }

    private static int countDigitsRec(int num) {
        if(num == 0)
            return 0;
        return 1 + countDigitsRec(num/10);
    }
}
