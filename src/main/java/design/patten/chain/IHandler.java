package design.patten.chain;

/**
 * desc : 抽象处理者
 * Created by tiantian on 2018/8/19
 */
public interface IHandler {
    void handle();
    
    void setNextHandler(IHandler handler);
    
    IHandler getNextHandler();
}
