package design.patten.prototype;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tiantian on 2018/7/3.
 */
public class Prototype implements Cloneable{
    
    public String property = "property";
    
    public List<String> list = new ArrayList<>();
    
    public Prototype() {
        list.add("hehe");
    }
    
    public void printProperty() {
        System.out.println(property);
    }
    
    public void setProperty(String p) {
        this.property = p;
    }
    
    public void addToList(String s) {
        this.list.add(s);
    }
    
    public void setList(List list) {
        this.list = list;
    }
    
    public void printList() {
        System.out.println(this.list.toString());
    }
    
    @Override
    public Prototype clone() throws CloneNotSupportedException {
        String property = this.property;
        
        List<String> list = new ArrayList<>(this.list);
        
        Prototype copy = new Prototype();
        copy.setProperty(property);
        copy.setList(list);
        return copy;
    }
}
