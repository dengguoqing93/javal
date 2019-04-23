package org.guoqing.chap5;

/**
 * RealData的代理
 *
 * @author dengguoqing
 * @date 2019/4/22
 */
public class FutureData implements Data {
    protected RealData realData;
    protected boolean isReady = false;

    public synchronized void setRealData(RealData realData) {
        if (isReady){
            return;
        }
        this.realData = realData;
        isReady = true;
        notifyAll();
    }

    @Override
    public synchronized String getResult() {
        while (!isReady){
            try {
                wait();
            } catch (InterruptedException e) {

            }
        }
        return realData.getResult();
    }
    
}
