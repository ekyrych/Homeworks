package com.company.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Task4 {

    public static void main(String[] args) {

        List<Integer> numbers =  new Random().ints(0,11)
                .limit(10)
                .boxed()
                .collect(Collectors.toList());

        System.out.println(numbers);

        System.out.println(numbers.stream()
                .mapToInt(i -> i)
                .max());

        System.out.println(numbers.stream()
                .mapToInt(i -> i)
                .min());

        System.out.println(numbers.stream()
                .mapToInt(i -> i)
                .average());

        System.out.println(numbers.stream()
                .mapToInt(i -> i)
                .sum());

        System.out.println(numbers.stream()
                .mapToInt(i -> i)
                .reduce((left, right) -> left+right));
    }

}
