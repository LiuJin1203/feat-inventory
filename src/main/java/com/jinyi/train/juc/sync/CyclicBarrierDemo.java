package com.jinyi.train.juc.sync;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * 循环栅拦
 * @author liujin
 * @date 2021/12/26
 * @since JDK8
 */
public class CyclicBarrierDemo {
        public static void main(String[] args) {

            int N = 5;  // 运动员数
            CyclicBarrier cb = new CyclicBarrier(N, () -> System.out.println("****** 所有运动员已准备完毕，发令枪：跑！******"));

            for (int i = 0; i < N; i++) {
                Thread t = new Thread(new PrepareWork(cb), "运动员[" + i + "]");
                t.start();
            }

        }


        private static class PrepareWork implements Runnable {
            private CyclicBarrier cb;

            PrepareWork(CyclicBarrier cb) {
                this.cb = cb;
            }

            @Override
            public void run() {

                try {
                    Thread.sleep(50);
                    System.out.println( Thread.currentThread().getName() + "准备完成.");
                    cb.await();          // 在栅栏等待

                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }
        }
    }
