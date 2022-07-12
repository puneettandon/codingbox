package com.leetcode;

public class ReverseInteger {

    public static void main(String[] args) {

        int num = 123;

        System.out.println("Reverse Integer: "+reverse(num));
    }

    private static int reverse(int num) {

        int reversed = 0;
        int pop;

        while( num != 0){
            pop = num % 10;
            num = num/10;

            if(reversed > Integer.MAX_VALUE/10 || reversed == Integer.MAX_VALUE/10 && pop > 7 ){
                return  0;
            }
            if(reversed < Integer.MIN_VALUE/10 || reversed == Integer.MIN_VALUE/10 &&  pop < -8 ){
                return  0;
            }

            reversed = (reversed * 10) + pop;
        }
        return  reversed;
    }
}
