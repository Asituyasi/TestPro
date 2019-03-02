package design.patten.memento;

import java.util.ArrayList;
import java.util.List;

/**
 * desc : 负责人
 * Created by tiantian on 2018/8/26
 */
public class CareTaker {
    private List<Memento> list = new ArrayList<>();

    public void add(Memento m) {
        this.list.add(m);
    }
    
    public Memento get(int i) {
        return this.list.get(i);
    }
}
