package org.guoqing.chap5;

import com.lmax.disruptor.BlockingWaitStrategy;
import com.lmax.disruptor.RingBuffer;
import com.lmax.disruptor.dsl.Disruptor;
import com.lmax.disruptor.dsl.ProducerType;

import java.nio.ByteBuffer;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * Disruptor框架生产者
 *
 * @author dengguoqing
 * @date 2019/4/22
 */
public class DisProducer {
    private final RingBuffer<PCData> ringBuffer;

    public DisProducer(RingBuffer<PCData> ringBuffer) {
        this.ringBuffer = ringBuffer;
    }

    public void pushData(ByteBuffer buffer) {
        long sequence = ringBuffer.next();
        try {
            PCData event = ringBuffer.get(sequence);
        } finally {
            ringBuffer.publish(sequence);
        }
    }

    public static void main(String[] args) throws Exception {
        Executor executor = Executors.newCachedThreadPool();
        PCDataFactory factory = new PCDataFactory();
        int bufferSize = 1024;
        Disruptor<PCData> disruptor = new Disruptor<PCData>(factory, bufferSize, executor,
                                                            ProducerType.MULTI,
                                                            new BlockingWaitStrategy());
        disruptor.handleEventsWithWorkerPool(new DisConsumer(), new DisConsumer(),
                                             new DisConsumer(),
                                             new DisConsumer());
        disruptor.start();
        RingBuffer<PCData> ringBuffer = disruptor.getRingBuffer();
        DisProducer producer = new DisProducer(ringBuffer);
        ByteBuffer buffer = ByteBuffer.allocate(8);
        for (long l = 0; true; l++) {
            buffer.putLong(0, l);
            producer.pushData(buffer);
            Thread.sleep(100);
            System.out.println("add data " + l);
        }
    }
}
