package org.guoqing.multi.guide.chap3;

import org.guoqing.multi.guide.CircularSeqGenerator;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 使用显示锁实现循环递增序列号生成器
 *
 * @author dengguoqing
 * @date 2019/6/21
 */
public class LockBaseCircularSeqGenerator implements CircularSeqGenerator {
    private short sequence = -1;
    private final Lock lock = new ReentrantLock();

    @Override
    public short nextSequence() {
        lock.lock();
        try {
            if (sequence >= 999) {
                sequence = 0;
            } else {
                sequence++;
            }
            return sequence;
        } finally {
            lock.unlock();
        }
    }
}
