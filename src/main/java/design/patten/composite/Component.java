package design.patten.composite;

/**
 * desc : 组合接口
 * Created by tiantian on 2018/10/16
 */
public interface Component {
    void display();
    void add(Component component);
    void remove(Component component);
}
