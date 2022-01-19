package com.practice.onlineTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Links {

    public static void main(String[] args) {

        String arr1[] = {"link1a","link1b","link1c","link1e","link1e"};
        String arr2[] = {"link2a","link2b","link2c","link2d","link1e"};

        List<String[]> arrlist = new ArrayList<>();

        arrlist.add(arr1);
        arrlist.add(arr2);

        arrlist.forEach(a -> System.out.println(Arrays.toString(a)));

    }
}
