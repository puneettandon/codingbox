package com.practice.coding;

import java.util.*;

// 110 print characters in descending order of frequency
public class DescendingOrderCharacterFrequency {

    public static void main(String[] args) {

        String str = "Banana";

        printCharacterFrequencyDescending(str);
    }

    private static void printCharacterFrequencyDescending(String str) {

        HashMap<Character,Integer> hm = new HashMap<>();
        for(int i = 0; i< str.length();i++){
            char c = str.charAt(i);
            if(!hm.containsKey(c)){
                 hm.put(c,1);
            }else {
                hm.put(c,hm.get(c)+1);
            }
        }

        System.out.println("map : "+hm);
        Set<Map.Entry<Character,Integer>> set = hm.entrySet();
        System.out.println("set : "+set);
        List<Map.Entry<Character,Integer>> list  = new ArrayList<>(set);
        System.out.println("list: "+list);
        Collections.sort(list, new Comparator<Map.Entry<Character, Integer>>() {
            @Override
            public int compare(Map.Entry<Character, Integer> o1, Map.Entry<Character, Integer> o2) {
                return o2.getValue().compareTo(o1.getValue());
            }
        });

        for(Map.Entry<Character,Integer> entry : list ){
            System.out.println("The frequency of occurence of "+ entry.getKey() + " is : "+entry.getValue());
        }

    }
}
