package com.practice.onlineTest;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.IntStream;

public class OpenTextDemo {

        public static int smallestIntegerNotExistInArray(int[] A) {
            // write your code in Java SE 8

            Integer[] newArr = Arrays.stream( A ).boxed().toArray( Integer[]::new );
            int min = Collections.min(Arrays.asList(newArr));
            int max = Collections.max(Arrays.asList(newArr));
            boolean contains = false;
            int smallest = -1;
            for(int i = min; i <= max ; i++){
                int j = i;
                contains = IntStream.of(A).anyMatch(x -> x == j);
                if(!contains){
                   if(i < 0){
                       continue;
                   }else {
                       smallest = i;
                       break;
                   }
                }
            }

            if(contains == true && smallest > 0){
                smallest  = max +1;
            }else{
                smallest = 1;
            }
           return smallest;

        }

    public static void main(String[] args) {

            int arr[] = {-1,-3};

       int smallest =  smallestIntegerNotExistInArray(arr);
        System.out.println("Smallest element is : "+ smallest);

        int smallestPositiveInteger = smallestPositveIntegerUsingHashSet(arr);

        System.out.println("Smallest Positve Integer using HashSet: "+smallestPositiveInteger);

    }

    private static int smallestPositveIntegerUsingHashSet(int[] arr) {

            int n = arr.length;
            int smallest = -1;
        Set<Integer> set =  new HashSet<>();
        for(int a : arr){
            if(a > 0 ){
                set.add(a);
            }
        }
        System.out.println("Set: "+set);
        for(int i = 1 ; i <= n+1;i++){
            if(!set.contains(i)){
               smallest = i;
               break;
            }
        }
        return  smallest;
    }
}
