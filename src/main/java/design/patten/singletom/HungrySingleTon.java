package design.patten.singletom;

/**
 * Created by tiantian on 2018/6/29.
 * JVM加载该类时就创建对象，是线程安全的
 */

public class HungrySingleTon {

    private static HungrySingleTon uniqueInstance = new HungrySingleTon();
    
    private HungrySingleTon(){
        System.out.println("HungrySingleTon is creating a instance.");
    }
    
    public static HungrySingleTon getInstance() {
        return uniqueInstance;
    }
    
}


