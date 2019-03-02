package design.patten.state;

/**
 * desc : 热水器（状态模式中的环境类）
 * Created by tiantian on 2018/9/1
 */
public class WaterHeater {
    private WaterHeaterState state;
    private int temperature = 0;
    
    public void open() { 
        setState(new Heating());
        Thread t = new Thread(() -> {
            while (true) {
                this.heating();
                state.setTemperature(temperature);
                try {
                    // 休眠若干时间，模拟加热过程
                    Thread.sleep(1000);
                    showTemper();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                if (temperature == 100) {
                    setState(new StopHeating());
                    System.out.println("Heating done! temperature is "+ temperature);
                    break;
                }
            }
        });
        t.start();
    }
    
    public void setState(WaterHeaterState state) {
        this.state = state;
    }
    
    public WaterHeaterState getState() {
        return state;
    }
    
    public void heating() {
        temperature += 10;
    }
    
    public void showTemper() {
        state.showTemperature();
    }
}
