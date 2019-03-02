package design.patten.meidiator;

/**
 * desc : 同事接口
 * Created by tiantian on 2018/9/23
 */
public interface Colleague {
    
    void notify(String name);
    
    void receive();
    
    String getName();
}
