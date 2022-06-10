package com.leetcode;

public class StocksBuySell {

    // https://www.youtube.com/watch?v=34WE6kwq49U
    public static void main(String[] args) {

        int a[] = {5,2,6,1,4};
        System.out.println("Max Profit: "+stockBuySellMaxProfit(a));
    }

    private static int stockBuySellMaxProfit(int[] a) {
        int maxSoFarProfit = 0;
        int minSoFarProfit = a[0];

        for(int i = 0;i<a.length;i++){
            minSoFarProfit = Math.min(minSoFarProfit,a[i]);
            int profit = a[i] - minSoFarProfit;
            maxSoFarProfit = Math.max(maxSoFarProfit,profit);
        }
        return maxSoFarProfit;
    }
}
