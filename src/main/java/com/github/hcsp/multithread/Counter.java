package com.github.hcsp.multithread;

public class Counter {
    // 必须保证使用的是同一个锁，Integer随着加减引用一直在变化，两个synchronized拿到的不是同一个锁
    private static final Object lock = new Object();
    private Integer value = 0;

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
