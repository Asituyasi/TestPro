package design.patten.meidiator;


import java.util.HashMap;
import java.util.Map;

/**
 * desc : 媒介类
 * Created by tiantian on 2018/9/23
 */
public class Mediator {
    
    private static Map<String, Colleague> colleagues = new HashMap<>();
    
    public static void notify(String name) {
        Colleague colleague = colleagues.get(name);
        colleague.receive();
    }
    
    public static void add(Colleague colleague) {
        colleagues.put(colleague.getName(), colleague);
    }
}
