package org.guoqing.chap5;

/**
 * 最终的数据模型
 *
 * @author dengguoqing
 * @date 2019/4/22
 */
public class RealData implements Data {
    protected final String result;

    public RealData(String result) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            sb.append(result);
        }
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {

        }
        this.result = sb.toString();
    }

    @Override
    public String getResult() {
        return result;
    }

}
