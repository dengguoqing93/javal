package org.guoqing.chap3;

import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * 倒计时器:CountDownLatch
 *
 * @author dengguoqing
 * @date 2019/4/18
 */
public class CountDownLatchDemo implements Runnable {
    static final CountDownLatch end = new CountDownLatch(10);
    static final CountDownLatchDemo DEMO = new CountDownLatchDemo();

    @Override
    public void run() {
        try {
            Thread.sleep(new Random().nextInt(10) * 1000);
            System.out.println("check complete");

        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            end.countDown();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ExecutorService exec = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 10; i++) {
            exec.submit(DEMO);
        }

        end.await();
        System.out.println("Fire!");
        exec.shutdown();

    }
}
