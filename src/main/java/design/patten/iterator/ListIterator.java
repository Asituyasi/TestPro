package design.patten.iterator;

import java.util.List;

/**
 * desc : 具体列表表迭代器
 * Created by tiantian on 2018/8/12
 */
public class ListIterator implements Iterator {
    private MyList list;
    private int index;

    public ListIterator(MyList list) {
        this.list = list;
        index = 0;
    }

    @Override
    public Object next() {
        Object obj = list.get(index);
        index ++;
        return obj;
    }

    @Override
    public boolean hasNext() {
        if (index >= list.size()) {
            return false;
        } else {
            return true;
        }
    }
}
