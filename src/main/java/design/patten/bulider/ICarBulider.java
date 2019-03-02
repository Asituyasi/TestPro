package design.patten.bulider;

/**
 * Created by tiantian on 2018/6/18.
 */
public interface ICarBulider {

    void composeEngine(String engine);

    void composeSteelingWheel(String steelingWheel);

    void composeWheel(String wheel);

    Car buildCar();
}
