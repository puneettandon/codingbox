package com.leetcode;

public class StocksBuySellV2 {

    // https://www.youtube.com/watch?v=Q7v239y-Tik
    //https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/
    public static void main(String[] args) {

        int stockPrices[] = {5,2,6,1,4,7,3,6};

        System.out.println("Max profit: " + maxProfit(stockPrices));

    }

    private static int maxProfit(int[] stockPrices) {

        int profit = 0;
        for(int i = 1;i <stockPrices.length;i++){
            if(stockPrices[i] > stockPrices[i-1]){
                profit += stockPrices[i] - stockPrices[i-1];
            }
        }
        return profit;
    }
}
