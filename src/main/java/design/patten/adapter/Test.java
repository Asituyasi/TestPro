package design.patten.adapter;

/**
 * desc : 测试
 * Created by tiantian on 2018/10/2
 */
public class Test {
    public static void main(String[] args) {
        Target adapter = new Adapter();
        adapter.function1();
        adapter.function2();
    }
//    I'm function1() who can do something, tut not enough.
//    I'm function2() who can do another thing.
}
