package design.patten.state;

/**
 * desc : 热水器测试
 * Created by tiantian on 2018/9/1
 */
public class WaterHeaterTest {
    public static void main(String[] args) throws InterruptedException {
        WaterHeater wh = new WaterHeater();
        wh.open();
    }
}
// output:
// Water is heating and temperature is 10 now
// Water is heating and temperature is 20 now
// Water is heating and temperature is 30 now
// Water is heating and temperature is 40 now
// Water is heating and temperature is 50 now
// Water is heating and temperature is 60 now
// Water is heating and temperature is 70 now
// Water is heating and temperature is 80 now
// Water is heating and temperature is 90 now
// Water is heating and temperature is 100 now
// Heating done! temperature is 100
