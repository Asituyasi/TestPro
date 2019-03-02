package design.patten.chain;

/**
 * desc : 具体处理者A
 * Created by tiantian on 2018/8/19
 */
public class HandlerA implements IHandler {
    private IHandler nextHandler = null;
    
    @Override
    public void handle() {
        System.out.println("HandlerA do something");
        if (this.hasNext()) {
            nextHandler.handle();
        }
    }

    @Override
    public void setNextHandler(IHandler handler) {
        this.nextHandler = handler ;
    }

    @Override
    public IHandler getNextHandler() {
        return nextHandler;
    }
    
    private boolean hasNext() {
        return nextHandler != null;
    }
}
