package design.patten.bulider;


/**
 * Created by tiantian on 2018/6/18.
 */
public class CarBuilder implements ICarBulider {
    
    private Car car = new Car();

    @Override
    public void composeEngine(String engine) {
        car.setEnging(engine);
    }

    @Override
    public void composeSteelingWheel(String steelingWheel) {
        car.setSteelingWheel(steelingWheel);
    }

    @Override
    public void composeWheel(String wheel) {
        car.setWheel(wheel);
    }
    
    @Override
    public Car buildCar() {
        return car;
    }
}
