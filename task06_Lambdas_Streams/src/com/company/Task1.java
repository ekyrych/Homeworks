package com.company;

public class Task1 {

    public static void main(String[] args) {
        Function function = (a,b,c) -> Math.max(a,Math.max(b,c)) ;
        System.out.println(function.task(4,5,6));
    }
}
