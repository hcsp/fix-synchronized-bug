package com.github.hcsp.multithread;

//import java.util.concurrent.atomic.AtomicInteger;

import java.util.concurrent.locks.ReentrantLock;

public class Counter {
    private Integer value = 0;

//    public int getValue() {
//        return value;
//    }
//
//    // 加上一个整数i，并返回加之后的结果
//    public synchronized int addAndGet(int i) {
//        value += i;
//        return value;
//    }
//
//    // 减去一个整数i，并返回减之后的结果
//    public synchronized int minusAndGet(int i) {
//        value -= i;
//        return value;
//    }

    //    private AtomicInteger value = new AtomicInteger(0);
//
//    public int getValue() {
//        return value.get();
//    }
//
//    // 加上一个整数i，并返回加之后的结果
//    public int addAndGet(int i) {
//        return value.addAndGet(i);
//    }
//
//    // 减去一个整数i，并返回减之后的结果
//    public int minusAndGet(int i) {
//        return value.addAndGet(-i);
//    }
    private ReentrantLock lock = new ReentrantLock();

    public int getValue() {
        return value;
    }

    public int addAndGet(int i) {
        try {
            lock.lock();
            value += i;
            return value;
        } finally {
            lock.unlock();
        }
    }

    public int minusAndGet(int i) {
        try {
            lock.lock();
            value -= i;
            return value;
        } finally {
            lock.unlock();
        }
    }
}
