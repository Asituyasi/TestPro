package design.patten.facade;

/**
 * desc : qq
 * Created by tiantian on 2018/10/6
 */
public class QQ {
    public void init() {
        System.out.println("QQ is initing.");
    }
    
    public void startUp() {
        init();
        run();
    }
    
    public void run() {
        System.out.println("QQ is runing.");
    }
    
    public void quit() {
        System.out.println("QQ is shutdown.");
    }
}
