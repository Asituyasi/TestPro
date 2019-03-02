package design.patten.proxy;

/**
 * desc : 目标代理类
 * Created by tiantian on 2018/10/7
 */
public class TargetProxy {
    private Target target;

    public TargetProxy(Target target) {
        this.target = target;
    }
    
    public void action() {
        System.out.println("befor target action");
        target.action();
        System.out.println("after target action");
    }
}
