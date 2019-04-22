package org.guoqing.chap5;

import com.lmax.disruptor.WorkHandler;

/**
 * Disruptor框架实现消费者
 *
 * @author dengguoqing
 * @date 2019/4/22
 */
public class DisConsumer implements WorkHandler<PCData> {
    @Override
    public void onEvent(PCData pcData) throws Exception {
        System.out.println(
                Thread.currentThread().getId() + " : Event : --" + pcData.getIntData() + "--");

    }
}
