package com.practice.dp;

public class Pattern1 {


    public static void main(String[] args) {

        int num = 4;
        int k = 0;
        int temp = 1;
        for(int i = 0 ; i <num; i++){
            k = temp;
            for(int j = temp;j<=(i+k);j++) {
                temp++;
                System.out.print(j);
            }
            System.out.println();
        }
    }

}


/*
1
3*2
4*5*6
10*9*8*7
11*12*13*14*15

 */
