package org.guoqing.chap5;

/**
 * 流水线任务执行
 *
 * @author dengguoqing
 * @date 2019/4/22
 */
public class PStreamMain {
    public static void main(String[] args) {
        new Thread(new Plus()).start();
        new Thread(new Multiply()).start();
        new Thread(new Div()).start();

        for (int i = 0; i < 100; i++) {
            Msg msg = new Msg();
            msg.i = i;
            msg.j = i;
            msg.orgStr = "((" + i + "+" + i + ")*" + i + ")/2";
            Plus.bq.add(msg);
        }
    }
}
