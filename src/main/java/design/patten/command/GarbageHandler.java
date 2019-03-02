package design.patten.command;

/**
 * desc : 垃圾回收命令处理器
 * Created by tiantian on 2018/8/11
 */
public class GarbageHandler {
    public void handleDiscard() {
        System.out.println("handleDiscard() method will recycle garbage.");
    }
    
    public void getBack() {
        System.out.println("getBack() method will get back the discarded. ");
    }
}
