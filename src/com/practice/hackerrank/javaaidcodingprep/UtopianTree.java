package com.practice.hackerrank.javaaidcodingprep;

import java.util.Scanner;

public class UtopianTree {

    // problem statement : https://www.hackerrank.com/challenges/utopian-tree/problem
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for(int i = 0; i < t;i++){
            int cycle = sc.nextInt();
            System.out.println("Growth for the cycle : "+cycle + " is : "+utopianTree(cycle));
        }
        sc.close();

    }

    private static int utopianTree(int cycle) {

        //     cycle >> 1 = cycle/2
        //      cycle >> 2 = cycle/4
        //      cycle >> 2 = cycle/8

        // 1 * ((2^(cycle/2) + 1) -1   * 2^cycle  % 2
        return  (1 << (( cycle >> 1 )+1 )) - 1 << cycle % 2;
    }

    private static int utopianTreeBasicSoln(int cycle){
// ToDo
        return 0;
    }

}
