package design.patten.stratery;

/**
 * Created by tiantian on 2018/7/14.
 */
public class Client {
    public static void main(String[] args) {
        OverdueInsurenceStrategy tenMinStrategy = new TenMinuteLateStrategy();
        PayContext context = new PayContext(tenMinStrategy);
        context.pay(22.9); // output : 20.61 RMB
    }
}

