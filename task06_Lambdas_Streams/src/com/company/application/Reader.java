package com.company.application;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Reader {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<String> words = new ArrayList<>();
        while(scan.hasNext()){
            String myLine = scan.nextLine();
            if(myLine == null || myLine.isEmpty()){
                break;
            }
            words.add(myLine);
        }
        System.out.println(words);

        System.out.println(words.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting())));

        System.out.println(words.stream()
                .distinct()
                .count());

        System.out.println(words.stream()
                .distinct()
                .sorted()
                .collect(Collectors.toList()));

        System.out.println(words.stream().flatMap(word -> Arrays.stream( word.split("")))
                .filter(s -> !s.toUpperCase().equals(s))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting())));
    }
}
