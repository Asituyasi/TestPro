package design.patten.templatemethod;

/**
 * desc :
 * Created by tiantian on 2018/7/28
 */
public class Client {
    public static void main(String[] args) {
        AbstractTemplateMethod templateMethod = new ConcreteTempleteMethod();
        templateMethod.templateMethod();
    }
}
