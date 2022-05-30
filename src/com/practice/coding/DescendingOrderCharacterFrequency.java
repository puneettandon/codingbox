package com.practice.coding;

import java.util.*;
import java.util.stream.Collectors;

// 110 print characters in descending order of frequency
public class DescendingOrderCharacterFrequency {

    public static void main(String[] args) {

        String str = "Banana";

        printCharacterFrequencyDescending(str);
        printCharacterFrequencyDescendingPr(str);
    }

    private static void  printCharacterFrequencyDescendingPr(String str) {

        HashMap<Character,Integer> hm = new HashMap<>();
        for(int i = 0;i< str.length();i++){
            char ch = str.charAt(i);
            if(!hm.containsKey(ch))
                hm.put(ch,1);
            else
                hm.put(ch,hm.get(ch)+1);
        }
                hm.entrySet().stream()
                        .sorted((k1, k2) -> -k1.getValue().compareTo(k2.getValue()))
                        .forEach(k -> System.out.println(k.getKey() + ": " + k.getValue()));

        System.out.println("Sorting by another way......");
        hm.entrySet().stream().sorted(Map.Entry.comparingByValue()).forEach(System.out::println);

        System.out.println("Sorting by one more way......");
        Map<Character,Integer> newMap = hm.entrySet().stream().sorted(Map.Entry.comparingByValue())
                .collect(Collectors.toMap(Map.Entry::getKey,Map.Entry::getValue,(oldValue,newValue)-> oldValue,LinkedHashMap::new));
        newMap.forEach((key, value) -> {
            System.out.println("Key : " + key + " Value : " + value);
        });
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
