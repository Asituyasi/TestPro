package design.patten.decorator;

/**
 * desc : 具体装饰者
 * Created by tiantian on 2018/10/5
 */
public class ConcteteDecoratorB extends Decorator {
    private Component component;

    public ConcteteDecoratorB(Component component) {
        this.component = component;
    }

    @Override
    public void doSomething() {
        System.out.println("Decorating component object.");
        component.doSomething();
        System.out.println("Decorating component object again.");

    }
}
