package design.patten.decorator;

/**
 * desc : 具体组件
 * Created by tiantian on 2018/10/5
 */
public class ConctreteComponentB implements Component{
    @Override
    public void doSomething() {
        System.out.println("world");
    }
}
