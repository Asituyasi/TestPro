package design.patten.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * desc : jdk动态代理
 * Created by tiantian on 2018/10/7
 */
public class MyHandle implements InvocationHandler {
    private Target target;

    public MyHandle(Target target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("befor invoke method.");
        method.invoke(target, args);
        System.out.println("after invoke method.");
        return null;
    }
}
