package com.hr.problemsolving;


import java.util.*;

// https://www.hackerrank.com/challenges/permutation-equation/problem?isFullScreen=true
public class PermutationCombination {

    public static void main(String[] args) {

        Integer[] arr= new Integer[] { 4,3,5,1,2};
        List<Integer> input = Arrays.asList(arr);

        List<Integer> result = PermutationCombination.permutationEquation(input);

        System.out.println(result.toString());

    }

    private static List<Integer> permutationEquation(List<Integer> input) {

        Integer p[] = input.stream().toArray(Integer[]::new);

        Arrays.stream(p).forEach(System.out::println);

        Integer[] eqArr = new Integer[p.length];

        Map<Integer, Integer> hash = new HashMap();

        for (int i = 1; i <= p.length; i++) {
            System.out.println("p[i]-1 : "+p[i-1] + " ...i = "+i);
            hash.put(p[i - 1], i); // 4,1    3,2   5,3   1,4  2,5
        }

        hash.entrySet().stream().forEach(System.out::println);

        for (int i = 0; i < eqArr.length; i++) {
            eqArr[i] = hash.get(hash.get(i + 1));
        }

        List<Integer> result = (List<Integer>) Arrays.asList(eqArr);
        return result;
    }


}
