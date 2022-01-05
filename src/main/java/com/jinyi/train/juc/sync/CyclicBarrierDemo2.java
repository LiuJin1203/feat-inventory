package com.jinyi.train.juc.sync;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;

/**
 * 循环栅拦
 *
 * @author liujin
 * @date 2021/12/26
 * @since JDK8
 */
public class CyclicBarrierDemo2 {
    private static final int N = 5;// 运动员数
    private static final int PerN = N + 1;// //运动员+颁奖人

    //名运动员先上场，都上场后，再让颁奖人上场，颁奖人上场后再开始颁奖
    public static void main(String[] args) throws InterruptedException {
        final Runnable award = () -> System.out.println("****** 运动员和颁奖人都已到达颁奖台，开始颁奖！******");
        CyclicBarrier cb = new CyclicBarrier(PerN, award);
        CountDownLatch cd = new CountDownLatch(N);
        for (int i = 1; i <= N; i++) {
            Thread t = new Thread(new Athlete(cb, cd), "运动员[" + i + "]");
            t.start();
        }
        cd.await();
        System.out.println("所有运动员准备好,等待颁奖人上台.");
        Thread t = new Thread(new Presenter(cb), "颁奖人ABC");
        t.start();
    }




}

/**
 * 颁奖人
 */
class Presenter implements Runnable{
    private CyclicBarrier cb;

    public Presenter(CyclicBarrier cb) {
        this.cb = cb;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "准备完成.");
        try {
            cb.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
    }
}
/**
 * 运动员
 */
class Athlete implements Runnable {
    private CyclicBarrier cb;
    private CountDownLatch cd;

    public Athlete(CyclicBarrier cb, CountDownLatch cd) {
        this.cb = cb;
        this.cd = cd;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(50);
            System.out.println(Thread.currentThread().getName() + "准备完成.");
            cd.countDown();       //运动员准备好
            cb.await();           // 在栅栏等待颁奖人

        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
    }
}