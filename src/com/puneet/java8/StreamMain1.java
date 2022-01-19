package com.puneet.java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamMain1 {

    public static void main(String[] args) {

        //create list and filter all even numbers from list
       List<Integer> list1 = List.of(2, 4, 50, 43, 89, 34); // list here is immutable
        //list1.add(345); // this will give error

        System.out.println(list1);

        List<Integer> list2 = new ArrayList<>(); //mutable list

        list2.add(12);  list2.add(23);   list2.add(54);  list2.add(89);

        List<Integer> list3 = Arrays.asList(43,54,89,234,889);


        // without stream
        List<Integer> listEven = new ArrayList<>();

        for(Integer i: list1){
            if(i % 2 == 0)
                listEven.add(i);
        }

        System.out.println(listEven);

        // using stream
        Stream<Integer> stream = list1.stream();
        //List<Integer> newEvenList = stream.filter(i -> i%2 == 0).collect(Collectors.toList());
        List<Integer> newEvenList = list1.stream().filter(i-> i%2==0).collect(Collectors.toList());
        System.out.println(newEvenList);

        List<Integer> greaterList = list1.stream().filter(i->i>10).collect(Collectors.toList());


        Stream<Object> emptyStream  = Stream.empty();
        String names[] = {"Ritvk","Ajay","Puneet"};
        Stream<String> stream1 = Stream.of(names);
        stream1.forEach(e -> System.out.println(e)) ;

        Stream<Object> streamBuilder = Stream.builder().build();

        IntStream stream2 = Arrays.stream(new int[]{2,3,58,43,98});
        stream2.forEach(e -> System.out.println(e));
    }
}
