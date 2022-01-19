package com.practice.onlineTest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.TreeMap;

public class ShortestUniqueSubstring {

    public static void main(String[] args) {

        String str = "zyzyzyz";
        int res = shortestUniqueSubstring(str);
        System.out.println("Shortest Unique Substring: "+res);

        System.out.println("Shortest unique string: "+shortUniqueString2(str));



    }

    private static int shortestUniqueSubstring(String str) {

        ArrayList<String> a1 = new ArrayList<>();

        for(int i = 0; i < str.length(); i++)
        {
            for(int j = i + 1; j <= str.length(); j++)
            {
                if (i != j)
                    a1.add(str.substring(i, j));
            }
        }

        TreeMap<String, Integer> a2 = new TreeMap<>();
        for(String s : a1)
            a2.put(s, a2.getOrDefault(s, 0) + 1);

        ArrayList<String> freshlist = new ArrayList<>();

        for(String s : a2.keySet())
        {
            if (a2.get(s) == 1)
                freshlist.add(s);
        }

        TreeMap<String, Integer> dictionary = new TreeMap<>();

        for(String s : freshlist)
        {
            dictionary.put(s, s.length());
        }

        ArrayList<Integer> newlist = new ArrayList<>();

        for(String s : dictionary.keySet())
            newlist.add(dictionary.get(s));

        int ans = Integer.MAX_VALUE;

        for(int i : newlist)
            ans = Math.min(ans, i);

        return ans == Integer.MAX_VALUE ? 0 : ans;
    }

    private static  int shortUniqueString2(String a){
        // Stores all occurences
        ArrayList<String> a1 = new ArrayList<>();

        // Generate all the substrings
        for(int i = 0; i < a.length(); i++)
        {
            for(int j = i + 1; j <= a.length(); j++)
            {
                // Append all substrings
                a1.add(a.substring(i, j));
            }
        }

        // Take into account
        // all the substrings
        HashMap<String, Integer> a2 = new HashMap<>();
        for(String s : a1)
            a2.put(s, a2.getOrDefault(s, 0) + 1);

        // Iterate over all
        // unique substrings
        int ans = Integer.MAX_VALUE;
        for(String s : a2.keySet())
        {

            // If frequency is 1
            if (a2.get(s) == 1)
                ans = Math.min(ans, s.length());
        }
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }
}
