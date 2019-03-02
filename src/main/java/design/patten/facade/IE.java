package design.patten.facade;

/**
 * desc : 浏览器
 * Created by tiantian on 2018/10/6
 */
public class IE {
    public void init() {
        System.out.println("IE is initing.");
    }

    public void startUp() {
        init();
        run();
    }

    public void run() {
        System.out.println("IE is runing.");
    }

    public void quit() {
        System.out.println("IE is shutdown.");
    }
}
