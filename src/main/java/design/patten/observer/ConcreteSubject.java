package design.patten.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * desc : 具体主题
 * Created by tiantian on 2018/7/22
 */
public class ConcreteSubject implements Subject {
    
    List<Observer> observers;
    String state = "state";

    public ConcreteSubject() {
        this.observers = new ArrayList<>();
    }

    @Override
    public void registerObserver(Observer observer) {
        this.observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        int index = observers.indexOf(observer);
        observers.remove(index);
     }

    @Override
    public void notifyObservers() {
        for(Observer o : observers) {
            o.update(this);
        }
    }

    @Override
    public void setState(String state) {
        this.state = state;
    }

    @Override
    public String getState() {
        return this.state;
    }
}
