package org.guoqing.chap7;

import akka.actor.AbstractActor;
import akka.actor.ActorRef;
import akka.actor.Props;
import akka.actor.UntypedAbstractActor;

/**
 * Actor实战
 *
 * @author dengguoqing
 * @date 2019/4/23
 */
public class HellodWorld extends UntypedAbstractActor {
    ActorRef greeter;

    @Override
    public void preStart() throws Exception {
        greeter = getContext().actorOf(Props.create(Greeter.class), "greeter");
        System.out.println("Greeter Actor Path: " + greeter.path());
        greeter.tell(Greeter.Msg.GREET, getSelf());
    }

    @Override
    public void onReceive(Object message) throws Throwable {
        if (message == Greeter.Msg.DONE) {
            greeter.tell(Greeter.Msg.GREET, getSelf());
            getContext().stop(getSelf());
        } else {
            unhandled(message);
        }
    }
}
