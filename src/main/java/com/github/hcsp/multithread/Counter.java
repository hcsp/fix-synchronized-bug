package com.github.hcsp.multithread;

import java.util.concurrent.locks.ReentrantLock;

public class Counter {
    private Integer value = 0;
    ReentrantLock lock = new ReentrantLock();

    public int getValue() {
        return value;
    }

    // 加上一个整数i，并返回加之后的结果
    public int addAndGet(int i) {
        synchronized (lock) {
            value += i;
            return value;
        }
    }

    // 减去一个整数i，并返回减之后的结果
    public int minusAndGet(int i) {
        synchronized (lock) {
            value -= i;
            return value;
        }
    }
}
