package design.patten.proxy;

import sun.misc.ProxyGenerator;

import java.io.*;
import java.lang.reflect.Proxy;

/**
 * desc : jdk动态代理测试
 * Created by tiantian on 2018/10/7
 */
public class JdkProxyTest {
    public static void main(String[] args) {
        Target target = new TargetImpl();
        MyHandle myHandle = new MyHandle(target);
        Class[] targetInterfaceClass = {Target.class};
        Target proxy = (Target) Proxy.newProxyInstance(target.getClass().getClassLoader(), targetInterfaceClass, myHandle);
        proxy.action();
        Class<? extends Target> proxyClass = proxy.getClass();
        System.out.println(proxyClass.getName());
        String proxyClassName = proxyClass.getName();
        byte[] classBytes = ProxyGenerator.generateProxyClass(proxyClassName, targetInterfaceClass);
        String filePath = "/Users/enn/" + proxyClassName + ".class";
        System.out.println(filePath);
        try {
            OutputStream out = new FileOutputStream(new File(filePath));
            try {
                out.write(classBytes);
                out.flush();
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
//    output:    
//    befor invoke method.
//    target do something
//    after invoke method.
}
