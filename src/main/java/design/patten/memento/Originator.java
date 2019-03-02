package design.patten.memento;

/**
 * desc : 发起人
 * Created by tiantian on 2018/8/26
 */
public class Originator {
    
    private String stat;
    
    public Memento creatMenemto() {
        return new Memento(this.stat);
    }
    
    public void setStatFromMemento(Memento memento) {
        this.stat = memento.getStat();
    }
    
    public void setStat(String stat) {
        this.stat = stat;
    }
    
    public String getStat() {
        return this.stat;
    }
}
