package com.practice.coding;

import java.util.Scanner;

public class PerfectSquare {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number: ");
        boolean isPerfect = false;
        Integer num = sc.nextInt();

        for(int i = 1;i<= num/2;i++){
            if(i*i == num){
                isPerfect = true;
                System.out.println("Given number is square of "+ i);
                return;
            }
        }
        if(!isPerfect)
            System.out.println("Given number is not perfect square");
    }
}
