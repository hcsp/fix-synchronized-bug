package com.github.hcsp.multithread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Counter {
    private final Lock lock = new ReentrantLock();
    private Integer value = 0;

    public int getValue() {
        return value;
    }

    // 加上一个整数i，并返回加之后的结果
    public synchronized void addAndGet(int i) {
        lock.lock();
        try {
            value += i;
        } finally {
            lock.unlock();
        }
    }

    // 减去一个整数i，并返回减之后的结果
    public synchronized void minusAndGet(int i) {
        lock.lock();
        try {
            value -= i;
        } finally {
            lock.unlock();
        }
    }
}
