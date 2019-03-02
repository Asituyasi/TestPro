package test;

/**
 * desc :
 * Created by tiantian on 2018/11/6
 */
public interface Java8InterfaceTest {
    void doSth();
    default void method() {
        System.out.println("method()");
    }
    default void method2() {
        System.out.println("method2()");
    }
}
