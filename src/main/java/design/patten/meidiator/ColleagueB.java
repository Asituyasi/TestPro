package design.patten.meidiator;

/**
 * desc : 具体同事A
 * Created by tiantian on 2018/9/23
 */
public class ColleagueB implements Colleague{
    
    private String name;

    public ColleagueB(String name) {
        this.name = name;
    }

    @Override
    public void notify(String name) {
        Mediator.notify(name);
    }

    @Override
    public void receive() {
        System.out.println("ColleagueB received message");
    }

    @Override
    public String getName() {
        return name;
    }
}
