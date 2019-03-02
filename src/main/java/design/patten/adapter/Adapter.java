package design.patten.adapter;

/**
 * desc : 适配器
 * Created by tiantian on 2018/10/2
 */
public class Adapter extends Adaptee implements Target{
    @Override
    public void function2() {
        System.out.println("I'm function2() who can do another thing.");
    }
}
