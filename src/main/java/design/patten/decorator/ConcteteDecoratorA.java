package design.patten.decorator;

/**
 * desc : 具体装饰者
 * Created by tiantian on 2018/10/5
 */
public class ConcteteDecoratorA extends Decorator {
    private Component component;

    public ConcteteDecoratorA(Component component) {
        this.component = component;
    }
    
    @Override
    public void doSomething() {
        System.out.println("Decorating component object.");
        component.doSomething();
        System.out.println("Decorating component object again.");

    }
}
