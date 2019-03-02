package muitithread.akka;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;
import akka.actor.UntypedActor;
import com.typesafe.config.ConfigFactory;

/**
 * desc :
 * Created by tiantian on 2018/11/11
 */
public class Greeter extends UntypedActor {
    public static enum Msg {
        GREET,DONE;
    }
    @Override
    public void onReceive(Object msg) throws Exception {
        if (msg == Msg.GREET) {
            System.out.println("Hello World!");
            getSender().tell(Msg.DONE, getSelf());
        } else {
            unhandled(msg);
        }
    }

    public static void main(String[] args) {
        ActorSystem system = ActorSystem.create("HelloWorldSys", ConfigFactory.load("samplehellow.conf"));
        ActorRef a = system.actorOf(Props.create(HelloWorld.class), "helloWorld");
        System.out.println("HelloWorld Actor Path:" + a.path());
    }
}

class HelloWorld extends UntypedActor {
    ActorRef greeter;

    @Override
    public void preStart() throws Exception {
        greeter = getContext().actorOf(Props.create(Greeter.class), "greeter");
        System.out.println("Greeter Actor Path:" + greeter.path());
        greeter.tell(Greeter.Msg.GREET, getSelf());
    }

    @Override
    public void onReceive(Object msg) throws Exception {
        if (msg == Greeter.Msg.DONE) {
            greeter.tell(Greeter.Msg.DONE, getSelf());
            getContext().stop(getSelf());
        } else {
            unhandled(msg);
        }
    }
}
