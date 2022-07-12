package com.leetcode;

import java.util.TreeMap;

public class HandOfStraights {

    // https://leetcode.com/problems/hand-of-straights/
    public static void main(String[] args) {

        int[] hand = {1,2,3,6,2,3,4,7,8};
        int groupSize = 4;

        System.out.println(isNStraightHand(hand,groupSize));
    }

    private static boolean isNStraightHand(int[] hand, int groupSize) {

        TreeMap<Integer,Integer> cardCounts = new TreeMap<>();

        for(int card: hand){
            if(!cardCounts.containsKey(card)){
                cardCounts.put(card,1);
            }else{
                cardCounts.replace(card,cardCounts.get(card) + 1);
            }
        }

        while(cardCounts.size() > 0){
            int firstCard = cardCounts.firstKey();
            for(int i = firstCard;i<firstCard + groupSize;i++){
                if(!cardCounts.containsKey(i)) return false;
                int count = cardCounts.get(i);
                if(count == 1){
                    cardCounts.remove(i);
                }else {
                    cardCounts.replace(i,cardCounts.get(i) - 1);
                }
            }
        }
        return true;
    }
}
