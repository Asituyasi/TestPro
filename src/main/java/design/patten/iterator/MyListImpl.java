package design.patten.iterator;

import java.util.ArrayList;
import java.util.List;

/**
 * desc : 具体容器
 * Created by tiantian on 2018/8/12
 */
public class MyListImpl implements MyList {
    private List list = new ArrayList();

    @Override
    public void add(Object obj) {
        list.add(obj);
    }

    @Override
    public void remove(int i) {
        list.remove(i);
    }

    @Override
    public Object get(int i) {
        return list.get(i);
    }

    @Override
    public int size() {
        return list.size();
    }

    @Override
    public Iterator iterator() {
        return new ListIterator(this);
    }
}
