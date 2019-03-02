package design.patten.state;

/**
 * desc : 加热状态具体实现
 * Created by tiantian on 2018/9/1
 */
public class Heating implements WaterHeaterState {
    
    private int temperature;

    @Override
    public void showTemperature() {
        System.out.println(String.format("Water is heating and temperature is %d now", temperature));
    }
    
    public void setTemperature(int temperature) {
        this.temperature = temperature;
    }
}
