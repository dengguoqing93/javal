package org.guoqing.multi.guide;

/**
 * 序列号生成器
 *
 * @author dengguoqing
 * @date 2019/6/21
 */
public interface CircularSeqGenerator {

    /**
     * 获取下一序列值
     *
     * @return short
     * @author dengguoqing
     * @date 2019/6/21
     * @since 1.0
     */
    short nextSequence();
}
