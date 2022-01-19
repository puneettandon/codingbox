package com.practice.coding;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class DuplicateCharactersWithOccurences {

    public static void main(String[] args) {

        String str = "puneettandon";

        printDuplicateCharactersWithOccurences(str);
    }

    private static void printDuplicateCharactersWithOccurences(String str) {
        Map<Character,Integer> map = new LinkedHashMap<>();

        for(int i = 0;i< str.length();i++){
            char c = str.charAt(i);
            if(!map.containsKey(c)){
                map.put(c,1);
            }else{
                map.put(c,map.get(c)+1);
            }
        }
        Set<Map.Entry<Character,Integer>> entrySet = map.entrySet() ;
        for(Map.Entry<Character,Integer> entry: entrySet){
         //   if(entry.getValue() > 1){
                System.out.println(entry.getKey() + " : "+ entry.getValue());
          //  }
        }
    }
}
