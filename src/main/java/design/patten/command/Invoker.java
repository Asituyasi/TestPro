package design.patten.command;

/**
 * desc : 命令请求者
 * Created by tiantian on 2018/8/11
 */
public class Invoker {

    private Command command;

    public Invoker(Command command) {
        this.command = command;
    }
    
    public void action() {
        command.excute();
    }
    
    public void withdraw() {
        command.withdraw();
    }
}
