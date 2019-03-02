package design.patten.bulider;

/**
 * Created by tiantian on 2018/6/18.
 */
public class Car {
    
    private String Enging;
    /**
     * desc:方向盘
     */
    private String SteelingWheel;
    
    /**
     * desc:轮子
     */
    private String wheel;

    public String getEnging() {
        return Enging;
    }

    public void setEnging(String enging) {
        Enging = enging;
    }

    public String getSteelingWheel() {
        return SteelingWheel;
    }

    public void setSteelingWheel(String steelingWheel) {
        SteelingWheel = steelingWheel;
    }

    public String getWheel() {
        return wheel;
    }

    public void setWheel(String wheel) {
        this.wheel = wheel;
    }

    @Override
    public String toString() {
        return "Car{" +
                "Enging='" + Enging + '\'' +
                ", SteelingWheel='" + SteelingWheel + '\'' +
                ", wheel='" + wheel + '\'' +
                '}';
    }
}
