package design.patten.composite;

import java.util.ArrayList;
import java.util.List;

/**
 * desc : 具有支节点的具体组合类
 * Created by tiantian on 2018/10/16
 */
public class Composite implements Component{
    private List<Component> subComposite = new ArrayList<>();
    @Override
    public void display() {
        System.out.println("I'm Composite, i have sub Composite");
    }

    @Override
    public void add(Component component) {
        subComposite.add(component);
    }

    @Override
    public void remove(Component component) {
        subComposite.remove(component);
    }
}
