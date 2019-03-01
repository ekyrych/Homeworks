package com.kyrychenko.multithreading.fibonacci;

public class FibonacciTask implements Runnable {
    private int n;
    private  int fibonacci;
    public FibonacciTask(int n) {
        this.n = n;
    }

    public int getFibonacci() {
        return fibonacci;
    }

    @Override
    public void run() {
        if( this.n <= 2 ) {
            this.fibonacci = 1;
        } else {
            FibonacciTask task1 = new FibonacciTask(this.n -1);
            FibonacciTask task2 = new FibonacciTask(this.n -2);
            Thread thread1 = new Thread(task1);
            Thread thread2 = new Thread(task2);
            thread1.start();
            thread2.start();
            try {
                thread1.join();
                thread2.join();
                this.fibonacci = task1.getFibonacci() + task2.getFibonacci();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        FibonacciTask fibonacciTask = new FibonacciTask(8);
        Thread thread = new Thread(fibonacciTask);
        thread.start();
        thread.join();
        System.out.println(fibonacciTask.getFibonacci());
    }


}
