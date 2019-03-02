package design.patten.command;

/**
 * desc : 命令接收者
 * Created by tiantian on 2018/8/11
 */
public class Receiver {
    public void action() {
        System.out.println(this.getClass().getCanonicalName() + " do action");
    }
}
