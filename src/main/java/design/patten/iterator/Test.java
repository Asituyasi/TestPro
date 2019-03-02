package design.patten.iterator;

/**
 * desc : 测试
 * Created by tiantian on 2018/8/12
 */
public class Test {
    public static void main(String[] args) {
        MyList myList = new MyListImpl();
        Iterator myListIterator = myList.iterator();

        System.out.println(myListIterator.hasNext());
        
        myList.add("hello");
        myList.add("world");
        myList.add("!");
        
        while (myListIterator.hasNext()) {
            System.out.println(myListIterator.next());
        }

    }
}
