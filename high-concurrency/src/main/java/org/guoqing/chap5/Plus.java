package org.guoqing.chap5;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * 加法运算
 *
 * @author dengguoqing
 * @date 2019/4/22
 */
public class Plus implements Runnable {
    public static BlockingQueue<Msg> bq = new LinkedBlockingDeque<>();

    @Override
    public void run() {
        while (true) {
            try {
                Msg msg = bq.take();
                msg.j = msg.i + msg.j;
                Multiply.bq.add(msg);
            } catch (InterruptedException e) {

            }

        }
    }
}
