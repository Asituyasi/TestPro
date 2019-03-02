package design.patten.proxy;

/**
 * desc : 静态代理测试
 * Created by tiantian on 2018/10/7
 */
public class Test {
    public static void main(String[] args) {
        TargetProxy proxy = new TargetProxy(new TargetImpl());
        proxy.action();
    }
    // output:
    // befor target action
    // target do something
    // after target action
}
