package design.patten.command;

/**
 * desc : 垃圾回收命令
 * Created by tiantian on 2018/8/11
 */
public class GarbageRecycleCommand implements Command {
    private final GarbageHandler receiver;

    public GarbageRecycleCommand(GarbageHandler receiver) {
        this.receiver = receiver;
    }

    @Override
    public void excute() {
        receiver.handleDiscard();
    }

    @Override
    public void withdraw() {
        receiver.getBack();
    }
}
