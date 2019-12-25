package com.github.hcsp.multithread;

class Counter {
    private Integer value = 0;
    Object obj = new Object();

    int getValue() {
        return value;
    }

    // 加上一个整数i，并返回加之后的结果
    int addAndGet(int i) {
        synchronized (obj) {
            value += i;
            return value;
        }
    }

    // 减去一个整数i，并返回减之后的结果
    int minusAndGet(int i) {
        synchronized (obj) {
            value -= i;
            return value;
        }
    }
}
