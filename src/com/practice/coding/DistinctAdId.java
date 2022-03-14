package com.practice.coding;

import java.util.*;
import java.util.stream.Collectors;

public class DistinctAdId {

    public static void main(String[] args) {

        Person p1 = new Person("puneet","22");
        Person p2 = new Person("aman","25");
        Person p3 = new Person("puneet","22");

        List<Person> list = new ArrayList<>();
        list.add(p1);
        list.add(p2);
        list.add(p3);

       // list.stream().forEach(p -> System.out.println(p.getName()));

        Collection<Person> name = list.stream().collect(Collectors.toMap(Person:: getName, p ->p ,(p, q)->p)).values();
       // name.stream().forEach(p -> System.out.println(p.getName()));
        Set<String> set = new HashSet<>();
        list.stream().filter(p-> set.add(p.getName())).collect(Collectors.toList());

        set.stream().forEach(p -> System.out.println(p));

    }
}


class Person {

    public Person(String name, String age) {
        this.name = name;
        this.age = age;
    }

    String name;
    String age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

}
