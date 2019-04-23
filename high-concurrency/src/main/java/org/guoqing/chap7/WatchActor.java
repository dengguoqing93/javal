package org.guoqing.chap7;

import akka.actor.ActorRef;
import akka.actor.Terminated;
import akka.actor.UntypedAbstractActor;
import akka.event.Logging;
import akka.event.LoggingAdapter;

/**
 * 监视者
 *
 * @author dengguoqing
 * @date 2019/4/23
 */
public class WatchActor extends UntypedAbstractActor {
    private final LoggingAdapter log = Logging.getLogger(getContext().system(), this);

    public WatchActor(ActorRef ref) {
        getContext().watch(ref);
    }

    @Override
    public void onReceive(Object message) throws Throwable {
        if (message instanceof Terminated) {
            System.out.println(String.format("%s has terminated,shutting down system",
                                             ((Terminated) message).getActor().path()));
            getContext().system().terminate();
        } else {
            unhandled(message);
        }
    }
}
