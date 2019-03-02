package design.patten.bridge;

/**
 * desc : 抽象化角色
 * Created by tiantian on 2018/10/8
 */
public abstract class Abstraction {
    protected Implementor implementor;

    public Abstraction(Implementor implementor) {
        this.implementor = implementor;
    }
    
    public abstract void action(); 
    
}
