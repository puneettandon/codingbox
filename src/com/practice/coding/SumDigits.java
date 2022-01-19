package com.practice.coding;

public class SumDigits {

    public static void main(String[] args) {

        int num = 46;
        int temp = 0;
        int sum = 0;

        while(num != 0){
            temp = num%10;
            num = num/10;
            sum = sum + temp;
        }
        System.out.println("Sum of digits: "+ sum);
    }
}
