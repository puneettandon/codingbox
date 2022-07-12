package com.leetcode;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangle {

    // https://leetcode.com/problems/pascals-triangle/
    public static void main(String[] args) {

        int numOfRows = 5;

        System.out.println("Pascal's Triangle:\n " + generatePascalsTriangle(numOfRows));

    }

    private static List<List<Integer>> generatePascalsTriangle(int numOfRows) {

        List<List<Integer>> triangle = new ArrayList<>();

        if(numOfRows == 0) return  triangle;

        List<Integer> firstRow = new ArrayList<>();
        firstRow.add(1);
        triangle.add(firstRow);

        for(int i = 1;i<numOfRows;i++){
            List<Integer> prevRow = triangle.get(i-1);
            List<Integer> row = new ArrayList<>();
            row.add(1);

            for(int j = 1;j<i;j++){
                row.add(prevRow.get(j-1) + prevRow.get(j));
            }
            row.add(1);
            triangle.add(row);
        }
        return triangle;
    }
}
