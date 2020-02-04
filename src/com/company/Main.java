package com.company;

import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        Recursion recursion = new Recursion();

        recursion.printNumbers(11);
        System.out.println();

        System.out.println(recursion.sumOfNumbers(12));
        System.out.println(recursion.isPalindrome("ABBA"));

        List<Product> products = Arrays.asList(
                new Product(1, "Audi", 1000),
                new Product(2, "Range", 2000),
                new Product(3, "Lada", 100),
                new Product(4, "Fiat", 500),
                new Product(5, "Toyota", 1000),
                new Product(6, "Kia", 600),
                new Product(7, "Volkswagen", 500),
                new Product(8, "Acura", 3000)

        );

        products.stream()
                .filter(product -> recursion.isPalindrome(product.getName()))
                .collect(Collectors.toList());
        System.out.println(products);
        List<String> names = sortNames(products);
        System.out.println(names);
        List<Product> products1 = sortPrice(products);
        System.out.println(products1);
        OptionalDouble products2 = averagePrice(products);
        System.out.println(products2);
        Map<Integer, Object> products3= getMap (products);
        System.out.println(products3);


    }

    public static List<String> sortNames(List<Product> products) {
        List<String> names = products.stream()
                .map(product -> product.getName())
                .sorted((product1, product2) -> product1.compareTo(product2))
                .collect(Collectors.toList());
        return names;
    }

    public static List<Product> sortPrice(List<Product> products) {
        List<Product> products1 = products.stream()
                .sorted((o1, o2) -> (-Integer.compare(o1.getPrice(), o2.getPrice())))
                .skip(5)
                .collect(Collectors.toList());
        return products1;
    }

    public static OptionalDouble averagePrice(List<Product> products) {
        OptionalDouble optional = products.stream()
                .map(product -> product.getPrice())
                .mapToInt((product) -> (product)).average();
        return optional;

    }

    public static Map<Integer, Object> getMap(List<Product> products) {
        Map<Integer, Object> products3 = products.stream()
                .collect(Collectors.toMap((product) -> product.getId(), (product) -> "name:" + product.getName() + ", price:" + product.getPrice()));
return products3;

    }
}
