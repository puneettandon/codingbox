package com.leetcode;

public class ContainerWithMostWater {

    // https://leetcode.com/problems/container-with-most-water/
    public static void main(String[] args) {

        int arr[] = {1,8,6,2,5,4,8,3,7};
        System.out.println("Max area height: " +maxArea(arr));


    }

    private static int maxArea(int[] height) {

        int maxArea = 0;
        int aPointer = 0;
        int bPointer = height.length - 1;
        while(aPointer < bPointer){
            if(height[aPointer] < height[bPointer]){
                maxArea = Math.max(maxArea,height[aPointer] * (bPointer - aPointer));
                aPointer += 1;
            }else {
                maxArea = Math.max(maxArea,height[bPointer] * (bPointer - aPointer));
                bPointer -= 1;
            }
        }
        return maxArea;
    }
}
