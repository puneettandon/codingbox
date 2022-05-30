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

        // practice
        int prNum = 8384;
        countDigitsItrPr(prNum);
        System.out.println("Rec Pr count: "+ countDigitsRecPr(prNum));
    }

    private static int countDigitsRecPr(int num) {
        if(num == 0)
            return 0;
        else return 1 + countDigitsRecPr(num/10);
    }

    private static void countDigitsItrPr(int num) {

        int count = 0;
        while(num > 0){
            num = num/10;
            count++;
        }
        System.out.println("Iter: count : "+count);
    }

    private static int countDigitsRec(int num) {
        if(num == 0)
            return 0;
        return 1 + countDigitsRec(num/10);
    }
}
