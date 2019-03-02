package design.patten.proxy;

import org.springframework.cglib.proxy.Enhancer;

/**
 * desc : spring cglib测试
 * Created by tiantian on 2018/10/7
 */
public class CglibTest {

    public static void main(String[] args) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(TargetImpl.class);
        enhancer.setCallback(new MyMethodIntercepter());
        Target tarProxy = (Target) enhancer.create();
        tarProxy.action();
    }
    // output:
    // befor method invoke. method = public void design.patten.proxy.TargetImpl.action()
    // target do something
    // after method invoke. method = public void design.patten.proxy.TargetImpl.action()
}
