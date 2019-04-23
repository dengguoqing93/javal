package org.guoqing.chap5;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * @author dengguoqing
 * @date 2019/4/22
 */
public class Multiply implements Runnable {
    public static BlockingQueue<Msg> bq = new LinkedBlockingDeque<>();

    @Override
    public void run() {
        while (true) {
            try {
                Msg msg = bq.take();
                msg.i = msg.i * msg.j;
                Div.bq.add(msg);
            } catch (InterruptedException e) {

            }
        }
    }
}
