package com.dynamicprogramming.techdose;

public class FibonacciNumber {

    public static void main(String[] args) {

        int number = 4;

        int res1 = fibonacciNumberUsingRecursion(number);
        System.out.println("Fibonacci Number using recursion :  "+ res1);

        int res2 = fibonacciNumberUsingDP(number);
        System.out.println("Fibonacci Number using DP "+ res2);

        int res3 = fibonacciNumberSpaceOptimized(number);
        System.out.println("Fibonacci Number Space Optimized "+ res3);
    }

    private static int fibonacciNumberSpaceOptimized(int number) {
        int a = 0, b = 1,c;
        if(number == 0){
            return a;
        }
        for(int i = 2;i<=number;i++){
            c = a + b;
            a = b;
            b = c;
        }
        return b;
    }

    private static int fibonacciNumberUsingDP(int number) {
        int[] arr = new int[number+2];
        arr[0] = 0;
        arr[1] = 1;
        for(int i = 2;i<=number;i++){
            arr[i] = arr[i-1] + arr[i-2];
        }
        return arr[number];
    }

    private static int fibonacciNumberUsingRecursion(int number) {

        if(number <= 1){
            return number;
        }else{
            return fibonacciNumberUsingRecursion(number -1) + fibonacciNumberUsingRecursion(number-2);
        }

    }
}
