package design.patten.stratery;

/**
 * Created by tiantian on 2018/7/14.
 */
public class PayContext {
    
    OverdueInsurenceStrategy strategy;
    
    PayContext(OverdueInsurenceStrategy strategy) {
        this.strategy = strategy;
    }
    
    public void pay(double price) {
        System.out.println(strategy.computePrice(price) + " RMB");
    }
}
