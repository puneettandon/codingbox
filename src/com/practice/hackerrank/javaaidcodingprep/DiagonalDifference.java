package com.practice.hackerrank.javaaidcodingprep;

public class DiagonalDifference {

    public static void main(String[] args) {

        int arr[][] = {{10,20,30},{4,5,6},{7,8,9}};

        System.out.println("Diagonal Difference is : "+diagonalDifference(arr));
    }

    static int diagonalDifference(int arr[][]){
        int leftSum = 0;
        int rightSum = 0;
        int n = arr.length;
        for(int i = 0;i<n;i++){
            leftSum = leftSum + arr[i][i];
            rightSum = rightSum + arr[i][n-i-1];
        }
        System.out.println("Left Sum = "+leftSum);
        System.out.println("Right Sum = "+rightSum);
        return Math.abs(leftSum - rightSum);
    }
}
