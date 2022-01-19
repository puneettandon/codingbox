package com.practice.dp;

public class FibonacciSeries {

    public static void main(String[] args) {

        int num = 9;

        System.out.println(fibByRecursion(num));

        System.out.println(fibByDP(num));

        System.out.println(fibByDPSpaceOptimized(num));
    }

    private static int fibByRecursion(int num) {

        if(num <= 1)
            return  num;
        else return fibByRecursion(num -2) + fibByRecursion(num -1);
    }

    private static int fibByDP(int num) {

        int f[] = new int[num+2];

        f[0] = 0;
        f[1] = 1;

        for(int i = 2;i <= num; i++){
            f[i] = f[i-1] + f[i-2];
        }
        return  f[num];
    }

    private static int fibByDPSpaceOptimized(int num) {

        int a = 0, b = 1,c;
        if(num == 0)
            return a;
        for(int i = 2; i <= num;i++){
            c = a + b;
            a = b;
            b = c;
        }
        return  b;
    }





}
