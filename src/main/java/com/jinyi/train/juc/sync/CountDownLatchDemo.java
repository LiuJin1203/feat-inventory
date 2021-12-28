package com.jinyi.train.juc.sync;

import java.util.concurrent.CountDownLatch;

/**
 * 倒数计数器
 * @author liujin
 * @date 2021/12/24
 * @since JDK8
 */
public class CountDownLatchDemo {
    private static final int N = 5;

    public static void main(String[] args) throws InterruptedException {
        CountDownLatch signal = new CountDownLatch(N);

        for (int i = 0; i < N; ++i) {
            new Thread(new Worker(signal)).start();
        }

        signal.await();       // 主线程等待其它N个线程完成
        doSomething();
    }

    public static void doSomething() {
        System.out.println("主线程做些事情");
    }
}

class Worker implements Runnable {
    private final CountDownLatch compSignal;

    Worker(CountDownLatch compSignal) {
        this.compSignal = compSignal;
    }

    public void run() {
        doWork(Thread.currentThread().getName());
        compSignal.countDown(); //每个线程做完自己的事情后，就将计数器减去1
    }

    void doWork(String name) {
        System.out.println(name+"工作线程做些事情");
    }
}
