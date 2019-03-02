package design.patten.bridge;

/**
 * desc :
 * Created by tiantian on 2018/10/8
 */
public class Test {
    public static void main(String[] args) {
        RefinedAbstraction ra = new RefinedAbstraction(new ConcreteImplementorA());
        ra.action();
    }
}
