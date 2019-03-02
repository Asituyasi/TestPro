package design.patten.observer;

/**
 * desc : 具体观察者
 * Created by tiantian on 2018/7/22
 */
public class ConcreteObserver implements Observer{
    
    String state = "state";

    @Override
    public void update(Subject subject) {
        this.state = subject.getState();
    }
}
