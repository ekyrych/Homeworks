package task2;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class BlockingQueueMain {
    public static void main(String[] args) throws FileNotFoundException, InterruptedException {
        RandomAccessFile raf = new RandomAccessFile("Text.txt","rw");
        StringNIOBuffer buf = new StringNIOBuffer(raf.getChannel());
        Thread thread1 = new Thread(() -> {
            try {
                System.out.println("Thread1: " + buf.read());
            } catch (IOException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        Thread thread2 = new Thread(() -> {
            try {
                System.out.println("Thread2: " + buf.read());

            } catch (IOException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        thread1.start();
        thread2.start();
    }
}
