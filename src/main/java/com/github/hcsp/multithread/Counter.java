package com.github.hcsp.multithread;

public class Counter {
    private Integer value = 0;

    public int getValue() {
        return value;
    }

    // 加上一个整数i，并返回加之后的结果
    public synchronized void addAndGet(int i) {
        value += i;
    }

    // 减去一个整数i，并返回减之后的结果
    public synchronized void minusAndGet(int i) {
        value -= i;
    }
}
