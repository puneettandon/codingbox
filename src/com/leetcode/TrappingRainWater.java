package com.leetcode;


import java.util.Arrays;

// Rain water trapping
public class TrappingRainWater {

    // https://www.youtube.com/watch?v=UZG3-vZlFM4&t=87s
    public static void main(String[] args) {

        int a[] = {3,1,2,4,0,1,3,2};
        int n = a.length;
        int left[] = new int[n];
        int right[] = new int[n];
        System.out.println("left: "+ Arrays.toString(a));
        left[0] = a[0];
        for(int i = 1;i<n;i++){
            left[i] = Math.max(left[i-1],a[i]);
        }
        System.out.println("left: "+ Arrays.toString(left));
        right[n-1] = a[n-1];
        for(int i = n-2;i>=0;i--){
            right[i] = Math.max(right[i+1],a[i]);
        }
        System.out.println("left: "+ Arrays.toString(right));
        int ans = 0;
        for(int i = 0;i<n;i++){
            ans += (Math.min(left[i],right[i]) - a[i]);
        }

        System.out.println("Result : "+ans);
    }
}
