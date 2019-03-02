package test;

/**
 * desc :
 * Created by tiantian on 2018/11/6
 */
public class Java8InterfaceTestImpl implements Java8InterfaceTest {
    @Override
    public void doSth() {
        System.out.println("doSth()");
    }

    public static void main(String[] args) {
        Java8InterfaceTestImpl jtest = new Java8InterfaceTestImpl();
        jtest.doSth();
        jtest.method();
        jtest.method2();
    }
}
