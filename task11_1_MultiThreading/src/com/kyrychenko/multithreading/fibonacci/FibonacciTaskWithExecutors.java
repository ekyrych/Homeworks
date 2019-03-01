package com.kyrychenko.multithreading.fibonacci;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class FibonacciTaskWithExecutors implements Callable<Integer> {
    private int n;
    public FibonacciTaskWithExecutors(int n) {
        this.n = n;
    }



    @Override
    public Integer call() throws Exception {
        if( this.n <= 2 ) {
            return  1;
        } else {
            ExecutorService executor = Executors.newFixedThreadPool(2);
            FibonacciTaskWithExecutors task1 = new FibonacciTaskWithExecutors(this.n -1);
            FibonacciTaskWithExecutors task2 = new FibonacciTaskWithExecutors(this.n -2);
            List<Callable<Integer>> callables = Arrays.asList(task1,task2);
            return executor.invokeAll(callables).stream().map(future -> {
                try {
                    return future.get();
                } catch (Exception e) { throw new IllegalStateException(e); }
            })
                    .mapToInt(o->o).sum();

        }


    }


    public static void main(String[] args) throws Exception {

        FibonacciTaskWithExecutors fibonacciTask = new FibonacciTaskWithExecutors(8);
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        Integer fib = executorService.invokeAll(Arrays.asList(fibonacciTask)).stream().map(future -> {
            try {
                return future.get();
            } catch (Exception e) { throw new IllegalStateException(e); }
        }).mapToInt(o->o).sum();
        System.out.println(fib);
    }


}
