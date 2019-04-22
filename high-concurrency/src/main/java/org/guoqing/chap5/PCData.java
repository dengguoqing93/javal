package org.guoqing.chap5;

/**
 * 共享数据模型
 *
 * @author dengguoqing
 * @date 2019/4/22
 */
public final class PCData {
    private final int intData;

    public PCData(int intData) {
        this.intData = intData;
    }

    public int getIntData() {
        return intData;
    }

    @Override
    public String toString() {
        return "Data:" + intData;
    }

}
