package design.patten.adapterofobject.adapter;

/**
 * desc : 对象适配器
 * Created by tiantian on 2018/10/2
 */
public class Adapter implements Target {
    private Adaptee adaptee;

    public Adapter(Adaptee adaptee) {
        this.adaptee = adaptee;
    }
    
    public void function1() {
        adaptee.function1();
    }

    public void function2() {
        System.out.println("I'm function2() who can do another thing.");
    }
}
