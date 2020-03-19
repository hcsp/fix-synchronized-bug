package com.github.hcsp.multithread;

//老师，在方法三中，我有一个问题，请您看一下。
public class Counter {
    private Integer value = 0;
    final String h1 = "hello";
    final String h2 = "hello";
    //不要以字符串常量作为锁定队象
    //string 值相等的话，内存中只会有一个内存地址，h1,h2都指向同一个对象

    public int getValue() {
        return value;
    }

    // 加上一个整数i，并返回加之后的结果
    public void addAndGet(int i) {
        synchronized (h1) {
            value += i;
        }

    }

    // 减去一个整数i，并返回减之后的结果
    public void minusAndGet(int i) {
        synchronized (h2) {
            value -= i;
        }
    }
}

//public class Counter {
//    private Integer value = 0;
////  同步代码块，对整个类对象加锁，实现读和写的原子操作
//
//    public int getValue() {
//        return value;
//    }
//
//    // 加上一个整数i，并返回加之后的结果
//    public  void addAndGet(int i) {
//        synchronized (this){
//            value += i;
//        }
//    }
//
//    // 减去一个整数i，并返回减之后的结果
//    public  void minusAndGet(int i) {
//        synchronized (this){
//            value -= i;
//        }
//    }
//}

/**
 * 使用synchronized 修饰静态方法，相当于给整个类加了锁，使类中的读写操作具有原子性
 * 在这里，我遇到了一个问题
 * 测试文件中，一共重复了10次测试（ @RepeatedTest(10)），这个方法在每次测试中，value均能稳定的增加100,但是从第一次测试完后，value=100
 * 在第二次测试时，value值却从100开始变化，一直加到200，第三次从200开始一直加到300.。。
 * 在本方法的开始有给value赋值为0的操作，按理说每次测试完重新开始时value应该可以重新为0的，但却没有 ,我个人的理解是
 * value此时属于静态变量，静态变量是属于类的而不是对象，静态变量在第一次类加载时被存入方法区后便一直存在，而此后在堆中新建实例对象时
 * ，并不会再执行第一句的private static int value = 0(因为它不属于对象且已经存在在方法区中)，对这个问题的解决方法，我觉得可以再
 * 写一个静态初始化方法，每次在所有操作都做完后要结束本轮测试时调用一下该方法，在方法中给value赋值为0;
 * 不知道我的理解是否正确？
 */
//public class Counter {
//
//    private static int value = 0;
//    public synchronized static int getValue() {
//        return value;
//    }
//
//    // 加上一个整数i，并返回加之后的结果
//    public synchronized static void addAndGet(int i) {
//        value += i;
//    }
//
//    // 减去一个整数i，并返回减之后的结果
//    public synchronized static void minusAndGet(int i) {
//        value -= i;
//    }
//}
