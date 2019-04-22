package org.guoqing.chap5;

import com.lmax.disruptor.EventFactory;

/**
 * PCData的工厂类
 *
 * @author dengguoqing
 * @date 2019/4/22
 */
public class PCDataFactory implements EventFactory<PCData> {
    @Override
    public PCData newInstance() {
        return new PCData(10);
    }

}
