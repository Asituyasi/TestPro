package design.patten.facade;

/**
 * desc : 音乐播放器
 * Created by tiantian on 2018/10/6
 */
public class Itunes {
    public void init() {
        System.out.println("Itunes is initing.");
    }

    public void startUp() {
        init();
        run();
    }

    public void run() {
        System.out.println("Itunes is playing music.");
    }

    public void quit() {
        System.out.println("Itunes is shutdown.");
    }
}
