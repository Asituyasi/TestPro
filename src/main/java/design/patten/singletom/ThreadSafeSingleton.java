package design.patten.singletom;

/**
 * Created by tiantian on 2018/6/29.
 * 下面解释一下什么是指令重排序，一般来说，处理器为了提高程序运行效率，可能会对输入代码进行优化，
 * 它不保证程序中各个语句的执行先后顺序同代码中的顺序一致，但是它会保证程序最终执行结果和代码顺序执行的结果是一致的
 * 　 volatile作用1）保证了不同线程对这个变量进行操作时的可见性，即一个线程修改了某个变量的值，这新值对其他线程来说是立即可见的。
 * 　　2）禁止进行指令重排序。
 */

//public class ThreadSafeSingleton {
//    
//    private static ThreadSafeSingleton uniqueInstance;
//    
//    private ThreadSafeSingleton() {
//        System.out.println("ThreadSafeSingleton is creating a instance.");
//    }
//    //每次调用都同步会影响性能
//    public static synchronized ThreadSafeSingleton getInstance() {
//        if (uniqueInstance == null) {
//            return new ThreadSafeSingleton();
//        }
//        
//        return uniqueInstance;
//    }
//}

public class ThreadSafeSingleton {

    private volatile static ThreadSafeSingleton uniqueInstance;

    private ThreadSafeSingleton() throws Exception {
        if (uniqueInstance != null) {
            throw new Exception("can't build another Object");
        }
        System.out.println("ThreadSafeSingleton is creating a instance.");
    }
    
    // 防止反序列化生成对象
    private Object readResolve() {
        return uniqueInstance;
    }
    
    public static  ThreadSafeSingleton getInstance() throws Exception {
        if (uniqueInstance == null) {
            synchronized (ThreadSafeSingleton.class) {
                if (uniqueInstance == null) {
                    return new ThreadSafeSingleton();
                }
            }
        }
        return uniqueInstance;
    }
}


