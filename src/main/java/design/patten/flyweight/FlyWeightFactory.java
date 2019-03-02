package design.patten.flyweight;

import java.util.HashMap;
import java.util.Map;

/**
 * desc : 享元对象工厂（使用单例）
 * Created by tiantian on 2018/10/16
 */
public class FlyWeightFactory {
    private static Map<String,FlyWeight> flyWeightMap = new HashMap();
    final static class FactoryHolder {
        private static FlyWeightFactory flyWeightFactory = new FlyWeightFactory();
    }
    
    public FlyWeight creatFlyWeight(String intrinsicState) {
        if (flyWeightMap.get(intrinsicState) != null) {
            return flyWeightMap.get(intrinsicState);
        }
        ConcreteFlyWeightA cfwA = new ConcreteFlyWeightA(intrinsicState);
        addFlyWeigth(cfwA);
        return cfwA;
    }
    
    public static FlyWeightFactory getInstance() {
        return FactoryHolder.flyWeightFactory;
    }
    
    private synchronized static void addFlyWeigth(FlyWeight flyWeight) {
        flyWeightMap.put(flyWeight.getIntrinsicState(), flyWeight);
    }
}
