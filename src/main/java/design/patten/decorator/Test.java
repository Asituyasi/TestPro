package design.patten.decorator;

/**
 * desc : 测试
 * Created by tiantian on 2018/10/5
 */
public class Test {
    public static void main(String[] args) {
        Component component = new ConcreteComponentA();
        Component beDecoratedComp = new ConcteteDecoratorA(component);
        beDecoratedComp.doSomething();
    }
    // Decorating component object.
    // hello
    // Decorating component object again.
}
