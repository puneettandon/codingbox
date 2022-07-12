package com.practice.coding;

import java.util.HashMap;
import java.util.HashSet;

public class LongestSubstringWithoutRep {

    public static void main(String[] args) {

        String str = "puneettandon"; // abcd

        System.out.println("longest substring without rep is: "+longestSubstringWithoutRep(str));

        System.out.println("longest unique substring: "+longestUniqueSubsttr(str));

      //  System.out.println("Longest unique subString : "+ longestUniqueSubstring(str));

      //  System.out.println("longest substring unique using hashmap : "+ longestUniqueSubstringUsingHashMap(str));
    //    System.out.println("Longest substring prac: "+longestSubstringWithoutRepPractice1(str));
        System.out.println("Longest substring prac2: "+ longestUniqueSubstringPractice2(str));

        System.out.println("Length of max longest sub string : "+longestUniqueSubstring(str));
    }

    private static String longestSubstringWithoutRep(String str) {

        HashSet<Character> hs = new HashSet<>();
        String longestOverall = "";
        String longestTillnow = "";

        for(int i = 0;i< str.length();i++){
            char c = str.charAt(i);
            if(hs.contains(c)){
                longestTillnow = "";
                hs.clear();
            }
            longestTillnow += c;
            hs.add(c);

            if(longestTillnow.length()> longestOverall.length()){
                longestOverall = longestTillnow;
            }
        }
        return  longestOverall;
    }

    private static String longestSubstringWithoutRepPractice1(String str){
        HashSet<Character> hs = new HashSet<>();
        String longestOverall = "";
        String longestTillNow = "";
        for(int i = 0;i<str.length();i++){
            char c = str.charAt(i);
            if(hs.contains(c)){
                longestTillNow = "";
                hs.clear();
            }
            longestTillNow += c;
            hs.add(c);
            if(longestTillNow.length() > longestOverall.length()){
                longestOverall = longestTillNow;
            }
        }
        return longestOverall;
    }

    public static int longestUniqueSubsttr(String str)
    {
        int n = str.length();

        // Result
        int res = 0;

        for(int i = 0; i < n; i++)
            for(int j = i; j < n; j++) {
             //   System.out.println("i = " + i + " j = " + j);
                if (areDistinct(str, i, j))
                    res = Math.max(res, j - i + 1);
            }

        return res;
    }

    public static Boolean areDistinct(String str,
                                      int i, int j)
    {

        // Note : Default values in visited are false
        boolean[] visited = new boolean[26];

        for(int k = i; k <= j; k++)
        {
         //   System.out.println("i = "+ i + " j = "+j + " k = "+k);
         //   System.out.println(visited[str.charAt(k) - 'a']);
            if (visited[str.charAt(k) - 'a'] == true)
                return false;

            visited[str.charAt(k) - 'a'] = true;
        }
        return true;
    }

    public static  int longestUniqueSubstring(String str ){
        String test = "";

        // Result
        int maxLength = -1;

        // Return zero if string is empty
        if (str.isEmpty()) {
            return 0;
        }
        // Return one if string length is one
        else if (str.length() == 1) {
            return 1;
        }
        for (char c : str.toCharArray()) {
            String current = String.valueOf(c);

           System.out.println("current is: "+current);

            // If string already contains the character
            // Then substring after repeating character
            if (test.contains(current)) {
               System.out.println("substring : "+test.substring(test.indexOf(current)+1));
                test = test.substring(test.indexOf(current)
                        + 1);
            }
            test = test + c;
            System.out.println("test: "+test);
            maxLength = Math.max(test.length(), maxLength);
        }

        return maxLength;
    }


    private static int longestUniqueSubstringUsingHashMap(String s) {

        HashMap<Character, Integer> seen = new HashMap<>();
        int maximum_length = 0;
        int start = 0;

        for(int end = 0; end < s.length(); end++)
        {
            if(seen.containsKey(s.charAt(end)))
            {
                start = Math.max(start, seen.get(s.charAt(end)) + 1);
            }

            seen.put(s.charAt(end), end);
            maximum_length = Math.max(maximum_length, end-start + 1);
        }
        return maximum_length;
    }


    private static int longestUniqueSubstringUsingHashMapM2(String s){
        int ans = 0;

        int i = -1;
        int j = -1;
        HashMap<Character,Integer> map = new HashMap<>();
        while(true){
            boolean flag1 = false;
            boolean flag2 = false;
            while(i < s.length()-1){
                flag1 = true;
                i++;
                char ch = s.charAt(i);
                map.put(ch, map.getOrDefault(ch,0)+1);

                if(map.get(ch) == 2){
                    break;
                }else {
                    int len = i - j;
                    if(len > ans)
                        ans = len;
                }
            }
            while (j < i){
                flag2 = true;
                j++;
                char ch = s.charAt(j);
                map.put(ch,map.get(ch) -1 );

                if(map.get(ch) == 1)
                    break;
            }
            if(flag1 == false && flag2 == false)
                break;
        }

        return ans;
    }

    private static int  longestUniqueSubstringPractice2(String str){

        String longestTillnow = "" ;
        String longestOverall = "";

        for(int i  = 0;i<str.length()-1;i++){
            char c = str.charAt(i);
            int pos = longestTillnow.indexOf(c);
            if(pos != -1){
                System.out.println("longesttillnow before: "+longestTillnow + " pos: "+pos + " i = "+i);
              longestTillnow =  str.substring(pos + 1,i+1);
                System.out.println("longesttillnow after : "+longestTillnow);
            }
            longestTillnow += c;
            if(longestTillnow.length() > longestOverall.length()){
                longestOverall = longestTillnow;
            }
            System.out.println("Longest Overall "+longestOverall);
        }
        return 1;
    }
        

}
