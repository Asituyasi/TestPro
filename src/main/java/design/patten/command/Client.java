package design.patten.command;

/**
 * desc : 垃圾回收测试客户端
 * Created by tiantian on 2018/8/11
 */
public class Client {
    public static void main(String[] args) {
        GarbageHandler handler = new GarbageHandler();
        Command command = new GarbageRecycleCommand(handler);
        Invoker invoker = new Invoker(command);
        
        invoker.action();
        invoker.withdraw();
    }
    
    // handleDiscard() method will recycle garbage.
    // getBack() method will get back the discarded. 
}
