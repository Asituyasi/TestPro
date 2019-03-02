package algorithms.chapter10;


public class MyListTest {
    public static void main(String[] args) {
        MyList list = new MyList();
        
        list.insert(2);
        list.insert(3);
        list.insert(4);
        
        MyList.Node deleted = list.delete(4);
        System.out.println(deleted.getValue());

    }
}
