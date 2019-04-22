package org.guoqing.chap3;

import java.util.concurrent.locks.ReentrantLock;

/**
 * 重入锁案列
 *
 * @author dengguoqing
 * @date 2019/4/17
 */
public class ReenterLock implements Runnable {

    public static ReentrantLock lock = new ReentrantLock();
    public static int a = 0;

    @Override
    public void run() {
        for (int i = 0; i < 1000000; i++) {
            lock.lock();
            try {
                a++;
            }finally {
                lock.unlock();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ReenterLock tl = new ReenterLock();
        Thread t1 = new Thread(tl);
        Thread t2 = new Thread(tl);
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(a);
    }
}
