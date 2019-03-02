package design.patten.stratery;

/**
 * Created by tiantian on 2018/7/14.
 */
public class ThirtyMinutesStrategy implements OverdueInsurenceStrategy {
    @Override
    public double computePrice(double price) {
        return price * 0.7;
    }
}
