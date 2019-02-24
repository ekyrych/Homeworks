package com.company.Task6;

import java.io.IOException;
import java.io.RandomAccessFile;

public class NIOMain {
    public static void main(String[] args) throws IOException {
        RandomAccessFile raf = new RandomAccessFile("text.txt","rw");
        StringNIOBuffer buf = new StringNIOBuffer(raf.getChannel());

        System.out.println(buf.read());

        RandomAccessFile raf1 = new RandomAccessFile("output.txt","rw");
        StringNIOBuffer buf1 = new StringNIOBuffer(raf1.getChannel());
        buf1.write("I can write here!");
        buf1.close();
        buf.close();
    }
}
