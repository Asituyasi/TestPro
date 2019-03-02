package design.patten.meidiator;

/**
 * desc : 具体同事A
 * Created by tiantian on 2018/9/23
 */
public class ColleagueA implements Colleague{

    private String name;

    public ColleagueA(String name) {
        this.name = name;
    }
    
    @Override
    public void notify(String name) {
        Mediator.notify(name);
    }

    @Override
    public void receive() {
        System.out.println("ColleagueA received message");
    }

    @Override
    public String getName() {
        return name;
    }
}
