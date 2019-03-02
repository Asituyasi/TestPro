package design.patten.facade;

/**
 * desc : 外观模式测试
 * Created by tiantian on 2018/10/6
 */
public class Test {
    public static void main(String[] args) {
        Desktop desktop = new Desktop();
        desktop.startUpQQ();
        desktop.quitQQ();
        
        desktop.startUpItunes();
        desktop.quitItunes();
    }
//    output :    
//    QQ is initing.
//    QQ is runing.
//    QQ is shutdown.
//    Itunes is initing.
//    Itunes is playing music.
//    Itunes is shutdown.
}
