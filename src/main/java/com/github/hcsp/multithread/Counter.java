package com.github.hcsp.multithread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Counter {
    private Integer value = 0;
    private final Object lock = new Object();

    public int getValue() {
        return value;
    }

    // 加上一个整数i，并返回加之后的结果
    public int addAndGet(int i) {
        value += i;
        return value;
    }

    // 减去一个整数i，并返回减之后的结果
    public int minusAndGet(int i) {
        value -= i;
        return value;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        for (int i = 0; i < 10; i++) {
            if (test() == 0) {
                System.out.println(true);
            } else {
                System.out.println(false);
            }
        }
//        System.exit(0);
    }

    public static Integer test() throws ExecutionException, InterruptedException {
        ExecutorService threadPool = Executors.newFixedThreadPool(100);
        Counter counter = new Counter();

        List<Future<Void>> futures = new ArrayList<>();

        for (int i = 0; i < 100; ++i) {
            futures.add(
                    threadPool.submit(
                            () -> {
                                safeSleep();
                                counter.addAndGet(2);
                                counter.minusAndGet(2);
                                return null;
                            }));
        }

        for (Future future : futures) {
            future.get();
        }
        return counter.value;
    }

    private static void safeSleep() {
        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
