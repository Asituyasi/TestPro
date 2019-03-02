package design.patten.proxy;

import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * desc : 方法拦截器
 * Created by tiantian on 2018/10/7
 */
public class MyMethodIntercepter implements MethodInterceptor {
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("befor method invoke. method = " + method);
        Object object = methodProxy.invokeSuper(o, objects);
        System.out.println("after method invoke. method = " + method);
        return object;
    }
}
