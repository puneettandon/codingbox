package com.practice.coding;

import java.util.Scanner;

public class CheckPrime {

    public static void main(String[] args) {

        System.out.println("Enter the number to check if prime or not: ");

        Scanner sc = new Scanner(System.in);
        Integer num = sc.nextInt();
        boolean isPrime = true;

        for(int i = 2; i< num;i++){
            if(num % i == 0){
                isPrime = false;
            }
        }
        if(isPrime == true)
            System.out.println("Given number is a prime number");
        else
            System.out.println("Number is not prime");

        isPrimeNumberPr(num);
    }

    private static void isPrimeNumberPr(Integer num) {
        boolean isPrime = true;
        for(int i = 2;i<num;i++){
            if(num%i == 0){
                isPrime = false;
                break;
            }
        }
        if(isPrime == true)
            System.out.println("Num is prime");
        else
            System.out.println("Num is not prime");
    }

}
