package design.patten.state;

/**
 * desc : 停止加热状态
 * Created by tiantian on 2018/9/1
 */
public class StopHeating implements WaterHeaterState{
    private int temperature;

    @Override
    public void showTemperature() {
        System.out.println(String.format("Water is heating and temperature is %d now", temperature));
    }

    public void setTemperature(int temperature) {
        this.temperature = temperature;
    }
}
