package com.company;

import java.io.*;

public class Task2 {
    public static void main(String[] args) throws IOException{
        InputStream input1 = new BufferedInputStream(new FileInputStream("c:\\data\\big-file.txt"), 8*1024);
        OutputStream output1 = new BufferedOutputStream(new FileOutputStream("c:\\data\\output-file.txt"), 8*1024);
        output1.write(input1.read());
        output1.close();
        input1.close();

        InputStream input2 = new FileInputStream("c:\\data\\big-file.txt");
        OutputStream output2 = new FileOutputStream("c:\\data\\output-file.txt");
        output2.write(input2.read());
        output2.close();
        input2.close();
    }
}
