package com.jinyi.train.juc.lock;

import java.util.Date;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author liujin
 * @date 2022/1/24
 * @since JDK8
 */
public class ReentrantReadWriteLockDemo {


    public static void main(String[] args) {
        final Inner inner = new Inner();
        inner.put("1",new Date());
        Thread threadA = new Thread(()-> System.out.println(inner.get("1")));
        Thread threadB = new Thread(()->System.out.println(inner.get("1")));
        Thread threadC = new Thread(()->inner.put("2",new Date()));
        Thread threadD = new Thread(()->System.out.println(inner.get("1")));

        threadA.start();
        threadB.start();
        threadC.start();
        threadD.start();

    }



}

class Inner{
    private final Map<String, Date> m = new TreeMap<String, Date>();
    private final ReentrantReadWriteLock rwl = new ReentrantReadWriteLock();
    private final Lock r = rwl.readLock();
    private final Lock w = rwl.writeLock();

    public Date get(String key) {
        r.lock();
        try {
            return m.get(key);
        } finally {
            r.unlock();
        }
    }

    public String[] allKeys() {
        r.lock();
        try {
            return (String[]) m.keySet().toArray();
        } finally {
            r.unlock();
        }
    }

    public Date put(String key, Date value) {
        w.lock();
        try {
            return m.put(key, value);
        } finally {
            w.unlock();
        }
    }

    public void clear() {
        w.lock();
        try {
            m.clear();
        } finally {
            w.unlock();
        }
    }
}
