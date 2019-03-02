package design.patten.command;


/**
 * desc : 具体命令
 * Created by tiantian on 2018/8/11
 */
public class ConcreteCommand implements Command {
    private Receiver receiver;

    public ConcreteCommand(Receiver receiver) {
        this.receiver = receiver;
    }

    public void excute() {
        receiver.action();
    }

    @Override
    public void withdraw() {
        
    }
}
