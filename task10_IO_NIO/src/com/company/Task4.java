package com.company;

import java.io.*;

public class Task4 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("D:\\Git\\dev\\Homeworks\\task10_IO_NIO\\src\\com\\company\\Droid.java"));
        String line = br.readLine();

        while (line != null) {
            String str = line.trim();
            if (str.startsWith("//") || str.startsWith("/**") || str.startsWith("*") || str.startsWith("*/")){
                System.out.println(line);
            }
            line = br.readLine();
        }
    }
}
