package design.patten.iterator;

/**
 * desc : 抽象容器
 * Created by tiantian on 2018/8/12
 */
public interface MyList {
    void add(Object obj);
    
    void remove(int i);
    
    Object get(int i);
    
    int size();
    
    Iterator iterator();
}
