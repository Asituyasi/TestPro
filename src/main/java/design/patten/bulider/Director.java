package design.patten.bulider;

/**
 * 
 */
public class Director {
    public static Car constructCar(ICarBulider carBulider) {
        carBulider.composeEngine("德国制造");
        carBulider.composeWheel("四轮子汽车轮胎");
        carBulider.composeSteelingWheel("单幅");
        return carBulider.buildCar();
    }
}
