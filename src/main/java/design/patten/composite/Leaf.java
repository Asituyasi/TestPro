package design.patten.composite;

/**
 * desc : 无支节点的叶子组合类
 * Created by tiantian on 2018/10/16
 */
public class Leaf implements Component{
    @Override
    public void display() {
        System.out.println("I'm Leaf,i have no Composite");
    }

    @Override
    public void add(Component component) {
        // nothing to do
    }

    @Override
    public void remove(Component component) {
        // nothing to do
    }
}
