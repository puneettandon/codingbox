package com.practice.dp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HR {

    public static void main(String[] args) {
        ArrayList list1 = new ArrayList();
        list1.add(3);
        list1.add(1);

        ArrayList list2 = new ArrayList();
        list2.add(3);
        list2.add(2);

        List list3 = getLexicoList(list1,list2);
        System.out.println(list3.toString());
    }

    private static List getLexicoList(ArrayList<Integer> list1, ArrayList<Integer> list2) {
        ArrayList list3 = new ArrayList();
        for(int i = 0;i< list1.size();i++){
            for(int j = 0;j< list2.size();j++){
                int value = Integer.max(list1.get(j),list2.get(j));
                if(!list3.contains(value))
                    list3.add(value);
            }
        }
        return  list3;
    }
}
