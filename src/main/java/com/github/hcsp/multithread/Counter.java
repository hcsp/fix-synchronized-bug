package com.github.hcsp.multithread;

public class Counter {
    private Integer value = 0;

    public int getValue() {
        return value;
    }

    // 加上一个整数i，并返回加之后的结果
    public int addAndGet(int i) {
        synchronized (this) {
            value += i;
            return value;
        }
    }

    // 减去一个整数i，并返回减之后的结果
    public int minusAndGet(int i) {
        synchronized (this) {
            value -= i;
            return value;
        }
    }

    public static void main(String[] args) {
        Counter counter = new Counter();

        for (int i = 0; i < 1000; i++) {
            new Thread(() -> {
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                counter.addAndGet(2);
                counter.minusAndGet(1);
            }).start();
        }

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(counter.getValue());
    }
}
