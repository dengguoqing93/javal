package org.guoqing.chap7;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;
import com.typesafe.config.ConfigFactory;

/**
 * @author dengguoqing
 * @date 2019/4/23
 */
public class HelloMainSimple {
    public static void main(String[] args) {
        ActorSystem system = ActorSystem.create("hello",
                                                ConfigFactory.load("samplehello.conf"));
        ActorRef ref = system.actorOf(Props.create(HellodWorld.class), "helloWorld");
        System.out.println("HelloWorld Actor Path: " + ref.path());
    }
}
