package design.patten.memento;

/**
 * desc : 备忘录
 * Created by tiantian on 2018/8/26
 */
public class Memento {
    private String stat;

    public Memento(String stat) {
        this.stat = stat;
    }

    public void setStat(String s) {
        this.stat = s;
    }
    
    public String getStat() {
        return this.stat;
    }
}
