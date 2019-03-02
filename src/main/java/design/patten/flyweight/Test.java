package design.patten.flyweight;

public class Test {
    public static void main(String[] args) {
        FlyWeightFactory factory = FlyWeightFactory.getInstance();
        FlyWeight firstFlyWeightA = factory.creatFlyWeight("firstFlyWeightA");
        firstFlyWeightA.option();
        // 再次创建firstFlyWeightA的FlyWeight对象
        // 打印：ConcreteFlyWeightA option()
        FlyWeight firstFlyWeightA1 = factory.creatFlyWeight("firstFlyWeightA");
        // 打印：true，
        // 说明返回的是之前创建的对象
        System.out.println(firstFlyWeightA == firstFlyWeightA1);
    }
}
