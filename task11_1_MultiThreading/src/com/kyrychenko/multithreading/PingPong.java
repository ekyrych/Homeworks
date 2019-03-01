package com.kyrychenko.multithreading;

public class PingPong implements Runnable {

    private static final Object LOCK_OBJ = new Object();

    private String message;

    public PingPong(String message) {
        this.message = message;
    }

    @Override
    public void run() {
        while (true){
            synchronized(LOCK_OBJ){
                System.out.println(this.message +" -->" + Thread.currentThread().getName());
                LOCK_OBJ.notifyAll();

                try {
                    LOCK_OBJ.wait();
                } catch (InterruptedException e) {}
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        PingPong a = new PingPong("ping");
        PingPong b = new PingPong("pong");

        Thread t1 = new Thread(a);
        Thread t2 = new Thread(b);
        t1.start();
        t2.start();

        t2.wait();
        t1.join();

    }

}
