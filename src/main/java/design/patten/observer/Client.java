package design.patten.observer;

/**
 * desc :
 * Created by tiantian on 2018/7/22
 */
public class Client {
    public static Subject  subject = new ConcreteSubject();

    public static void main(String[] args) {
        Observer observer = new ConcreteObserver();
        subject.registerObserver(observer);
        subject.setState("New State!");
        
        subject.notifyObservers();
        
        System.out.println(((ConcreteObserver) observer).state);
    }
}
