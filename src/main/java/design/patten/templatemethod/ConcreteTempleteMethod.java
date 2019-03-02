package design.patten.templatemethod;

/**
 * Created by tiantian on 2018/7/28
 */
public class ConcreteTempleteMethod extends AbstractTemplateMethod {
    @Override
    public void abstractMethod() {
        System.out.println("Do something");
    }
    
    @Override
    public void hookMethod() {
        System.out.println("Do something in hookMethod");
    }
}
