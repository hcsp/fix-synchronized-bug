package com.github.hcsp.multithread;

import java.util.concurrent.atomic.AtomicInteger;

public class Counter {
    private AtomicInteger value = new AtomicInteger(0);

    public int getValue() {
        return value.get();
    }

    // 加上一个整数i，并返回加之后的结果
    public int addAndGet(int i) {
//        【原因】synchronized锁住的对象，必须是不可变的。(最好不要使用原始包装类和String当做锁)
//              小明却在同步块中对锁对象Integer value进行了修改，本质还是线程不安全。
//        【解决方法】1. 改为synchronize(this) 或 synchronize(lock)
//                  2. 这里使用的是 AtomicInteger （更有效率）
//        synchronized (value) {
//            value += i;
//            return value;
//        }
        return value.addAndGet(i);
    }

    // 减去一个整数i，并返回减之后的结果
    public int minusAndGet(int i) {
        return value.addAndGet(-i);
    }
}
