package design.patten.singletom;

/**
 * Created by tiantian on 2018/6/29.
 */
public class LazySingleton {
    
    private static LazySingleton uniqueInstance;
    
    private LazySingleton() {
        System.out.println("LazySingleton is creating a instance.");
    }
    
    public static LazySingleton getInstance() {
        if (uniqueInstance == null) {
            return new LazySingleton();
        }
        
        return uniqueInstance;
    }
    
}
