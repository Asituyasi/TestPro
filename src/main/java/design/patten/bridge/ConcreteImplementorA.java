package design.patten.bridge;

/**
 * desc : 具体实现化角色实现A
 * Created by tiantian on 2018/10/8
 */
public class ConcreteImplementorA implements Implementor {
    @Override
    public void actionImpl() {
        System.out.println("ConcreteImplementorA action");
    }
}
