package design.patten.facade;

/**
 * desc : 电脑桌面（外观模式）
 * Created by tiantian on 2018/10/6
 */
public class Desktop {
    private QQ qq = new QQ();
    private Itunes itunes = new Itunes();
    private IE ie = new IE();
    
    public void startUpQQ() {
        qq.startUp();
    }
    
    public void quitQQ() {
        qq.quit();
    }
    
    public void startUpItunes() {
        itunes.startUp();
    }
    
    public void quitItunes() {
        itunes.quit();
    }

    public void startUpIe() {
        ie.startUp();
    }

    public void quitIe() {
        ie.quit();
    }
    
}
