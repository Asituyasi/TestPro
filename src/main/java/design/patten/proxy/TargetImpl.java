package design.patten.proxy;

/**
 * desc : 目标实现类
 * Created by tiantian on 2018/10/7
 */
public class TargetImpl implements Target{
    @Override
    public void action() {
        System.out.println("target do something");
    }
}
