package org.guoqing.chap7;

import akka.actor.*;
import com.typesafe.config.ConfigFactory;

/**
 * 主函数
 *
 * @author dengguoqing
 * @date 2019/4/23
 */
public class DeadMain {
    public static void main(String[] args) {
        ActorSystem system = ActorSystem.create("deadwatch",
                                                ConfigFactory.load("samplehello.conf"));
        ActorRef worker = system.actorOf(Props.create(MyWorker.class), "worker");
        system.actorOf(Props.create(WatchActor.class,worker), "watcher");
        worker.tell(MyWorker.MSg.WORKING, ActorRef.noSender());
        worker.tell(MyWorker.MSg.DONE, ActorRef.noSender());
        worker.tell(PoisonPill.getInstance(), ActorRef.noSender());
    }
}
