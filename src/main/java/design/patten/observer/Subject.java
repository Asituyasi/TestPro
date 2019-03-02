package design.patten.observer;

/**
 * desc : 抽象主题
 * Created by tiantian on 2018/7/22
 */
public interface Subject {
    
    void registerObserver(Observer observer);
    
    void removeObserver(Observer observer);
    
    void notifyObservers();
    
    public void setState(String state);
    
    public String getState();
}
