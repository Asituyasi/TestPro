package design.patten.bridge;

/**
 * desc : 修正抽象化角色
 * Created by tiantian on 2018/10/8
 */
public class RefinedAbstraction extends Abstraction{
    public RefinedAbstraction(Implementor implementor) {
        super(implementor);
    }

    @Override
    public void action() {
        super.implementor.actionImpl();
    }
}
