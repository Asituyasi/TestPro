package design.patten.memento;

public class Client {

    public static void main(String[] args) {
        Originator originator = new Originator();
        CareTaker careTaker = new CareTaker();
        originator.setStat("Stat1");
        Memento memento = originator.creatMenemto();
        careTaker.add(memento);
        
        originator.setStat("Stat2");
        System.out.println("目前状态");
        System.out.println(originator.getStat());

        System.out.println("恢复后的状态");
        originator.setStatFromMemento(careTaker.get(0));
        System.out.println(originator.getStat());
    }
}
