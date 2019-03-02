package design.patten.chain;

public class Test {
    public static void main(String[] args) {
        IHandler handlerA = new HandlerA();
        IHandler handlerB = new HandlerB();
        IHandler iHandlerC = new HandlerC();
        
        handlerA.setNextHandler(handlerB);
        handlerB.setNextHandler(iHandlerC);
        
        handlerA.handle();
    }

    // output:
    //HandlerA do something
    //HandlerB do something
    //HandlerC do something
}
