package com.company;

import java.io.File;
import java.io.IOException;

public class Task5 {
    public static void main(String[] args) throws IOException {
        File f = new File(".");

        File[] files = f.listFiles();
        for (File file : files) {
            if (file.isDirectory()) {
                System.out.print("directory:");
            } else {
                System.out.print("     file:");
            }
            System.out.println(file.getCanonicalPath());
        }
    }
}
