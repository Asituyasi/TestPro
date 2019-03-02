package design.patten.flyweight;

/**
 * desc : 具体享元类A
 * Created by tiantian on 2018/10/16
 */
public class ConcreteFlyWeightA implements FlyWeight{
    private String intrinsicState;

    public ConcreteFlyWeightA(String intrinsicState) {
        this.intrinsicState = intrinsicState;
    }

    @Override
    public void option() {
        System.out.println("ConcreteFlyWeightA option()");
    }

    @Override
    public String getIntrinsicState() {
        return intrinsicState;
    }
}
