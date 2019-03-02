package design.patten.flyweight;

/**
 * desc : 具体享元类B
 * Created by tiantian on 2018/10/16
 */
public class ConcreteFlyWeightB implements FlyWeight{
    private String intrinsicState;

    public ConcreteFlyWeightB(String intrinsicState) {
        this.intrinsicState = intrinsicState;
    }
    
    @Override
    public void option() {
        System.out.println("ConcreteFlyWeightB option()");
    }

    @Override
    public String getIntrinsicState() {
        return intrinsicState;
    }
}
