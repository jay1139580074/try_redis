package com.junjie.tryredis.demo;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class FlatMapDemo {

    public static void main(String[] args) {
        List<User> users = Arrays.asList(
                new User("Alice", Arrays.asList("123 Main St", "456 Oak St")),
                new User("Bob", List.of("789 Pine St")),
                new User("Charlie", Arrays.asList("101 Maple St", "202 Birch St"))
        );

        Set<String> collect = users.stream()
                .flatMap(user -> user.getAddresses().stream())
                .collect(Collectors.toSet());

        Set<List<String>> collect1 = users.stream()
                .map(user -> user.getAddresses())
                .collect(Collectors.toSet());

        System.out.println(collect);
        System.out.println("-------------------");
        System.out.println(collect1);

        List<String> words = Arrays.asList("apple", "banana", "cherry");

        Set<String> strs = words.stream()
                .map(str -> str.split(""))
                .map(str -> Arrays.toString(str))
                .collect(Collectors.toSet());

        Set<String> strs2 = words.stream()
                .flatMap(str -> Arrays.stream(str.split("")))
                .collect(Collectors.toSet());

        System.out.println(strs);
        System.out.println("-------------------");
        System.out.println(strs2);
    }
}

class User {
    String name;
    List<String> addresses;

    public User(String name, List<String> addresses) {
        this.name = name;
        this.addresses = addresses;
    }

    public List<String> getAddresses() {
        return addresses;
    }
}


