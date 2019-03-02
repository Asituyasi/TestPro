package design.patten.meidiator;

public class Test {
    public static void main(String[] args) {
        Colleague colleagueA = new ColleagueA("colleagueA");
        Colleague colleagueB = new ColleagueB("colleagueB");
        Mediator.add(colleagueA);
        Mediator.add(colleagueB);
        
        colleagueA.notify("colleagueB");
    }
}
