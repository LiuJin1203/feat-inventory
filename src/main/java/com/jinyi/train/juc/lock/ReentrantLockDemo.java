package com.jinyi.train.juc.lock;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 模拟三个线程获取资源
 * 查看获取锁的全过程
 *
 * @author liujin
 * @date 2022/1/19
 * @since JDK8
 */
public class ReentrantLockDemo {
    private static int count;
    //公平锁
    private static final ReentrantLock reentrantLock = new ReentrantLock(true);
    public static void main(String[] args) {
        Thread threadA = new Thread(()->add(),"threadA");
        Thread threadB = new Thread(()->add(),"threadB");
        Thread threadC = new Thread(()->add(),"threadC");
        threadA.start();
        threadB.start();
        threadC.start();
        System.out.println(Thread.currentThread().getName()+" count is: "+count);
    }

    public static void add() {
        System.out.println(Thread.currentThread().getName()+" enter add method。 @"+currentTime());
        reentrantLock.lock();
        System.out.println(Thread.currentThread().getName()+" enter add method and acquire lock。 @"+currentTime());
        try {
            for (int i = 0; i <100000 ; i++) {
                count++;
            }
            System.out.println(Thread.currentThread().getName()+" count is: "+count);
        } finally {
            //故意不释放锁，让其他线程排队，调试入栈过程
            try {
                Thread.sleep(1000*2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            reentrantLock.unlock();
        }

    }

    public static String currentTime(){
        SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd hh.mm.ss");
        return sd.format(new Date());
    }

}
