package design.patten.state;

/**
 * desc : 热水器状态接口
 * Created by tiantian on 2018/9/1
 */
public interface WaterHeaterState {
    
    void showTemperature();

    void setTemperature(int temperature);
}