package com.practice.onlineTest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class Holder {

    static String MAX_SIZE = System.getProperty("max.size");

    public static void main(String[] args) {

        Stream<String> stream = Stream.of("one", "two", "three", "four", "five");
        Predicate<String> p1 = s -> s.length() > 3;
        Predicate<String> p2 = s -> s.length() < 5;
        Predicate<String> p3 = s -> s.length() == 5;

        stream.filter(p1.and(p2.or(p3))).forEach(System.out::println);

        stream.filter(p1.or(p2.and(p3))).forEach(System.out::println);

    }

}
