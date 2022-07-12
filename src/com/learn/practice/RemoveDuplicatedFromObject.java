package com.learn.practice;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class RemoveDuplicatedFromObject {

    public static void main(String[] args) {
        List<Person> items = Arrays.asList(
                new Person("name-1", (int) 100.00),
                new Person("name-1", (int) 100.00),
                new Person("name-2", (int) 100.00),
                new Person("name-2", (int) 100.00),
                new Person("name-3", (int) 100.00),
                new Person("name-4", (int) 555.00),
                new Person("name-5", (int) 999.99)
        );

        List<Person> distinctPersons = items.stream()
                .filter(distinctByKeys(Person::getName, Person::getPrice))
                .collect(Collectors.toList());
        distinctPersons.forEach(item -> System.out.println(item.getName()+ "->" +item.getPrice()));

}

    private static <T> Predicate<T>
    distinctByKeys(final Function<? super T, ?>... keyExtractors)
    {
        final Map<List<?>, Boolean> seen = new ConcurrentHashMap<>();

        return t ->
        {
            final List<?> keys = Arrays.stream(keyExtractors)
                    .map(ke -> ke.apply(t))
                    .collect(Collectors.toList());

            return seen.putIfAbsent(keys, Boolean.TRUE) == null;
        };
    }
             
}
class Person{

    private String name;
    private Integer price;
    private Object otherField1;
    private Object otherField2;

    public Person(String name, Integer price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPrice() {
        return price;
    }

}

