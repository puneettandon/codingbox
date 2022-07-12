package com.leetcode;

public class JewelsStones {

    // https://leetcode.com/problems/jewels-and-stones/
    public static void main(String[] args) {

        String jewels = "aA";
        String stones = "aAAbbbb";

        System.out.println("Number of jewels in stones: "+numJewelsInStones(jewels,stones));
    }

    private static int numJewelsInStones(String jewels, String stones) {

        int numOfJewels = 0;

        for(int i = 0;i<stones.length();i++){
            if(jewels.indexOf(stones.charAt(i)) > -1){
                numOfJewels += 1;
            }
        }
        return numOfJewels;
    }
}
