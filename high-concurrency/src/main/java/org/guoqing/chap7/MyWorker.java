package org.guoqing.chap7;

import akka.actor.UntypedAbstractActor;
import akka.event.Logging;
import akka.event.LoggingAdapter;

/**
 * 带有生命周期回调函数的Actor
 *
 * @author dengguoqing
 * @date 2019/4/23
 */
public class MyWorker extends UntypedAbstractActor {

    private final LoggingAdapter log = Logging.getLogger(getContext().system(), this);

    public static enum MSg{
        WORKING,DONE,CLOSE;
    }

    @Override
    public void preStart() throws Exception {
        System.out.println("MyWorker is starting");
    }

    @Override
    public void postStop() throws Exception {
        System.out.println("MyWorker is stopping");

    }

    @Override
    public void onReceive(Object message) throws Throwable {
        if (message == MSg.WORKING) {
            System.out.println("I am working");
        }
        if (message == MSg.DONE) {
            System.out.println("Stop working");
        }
        if (message == MSg.CLOSE) {
            System.out.println("I will shutdown");
            getSender().tell(MSg.CLOSE, getSelf());
            getContext().stop(getSelf());
        }else {
            unhandled(message);
        }
    }
}
