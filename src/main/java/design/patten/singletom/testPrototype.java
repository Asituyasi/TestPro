package design.patten.singletom;

import design.patten.prototype.Prototype;

/**
 * Created by tiantian on 2018/7/3.
 */
public class testPrototype {
    public static void main(String[] args) throws CloneNotSupportedException {
        Prototype prototype = new Prototype();
        prototype.printProperty();
        prototype.printList();
        
        Prototype prototype2 = prototype.clone();
        prototype2.setProperty("property2");
        prototype2.printProperty();
        prototype2.addToList("haha");
        
        prototype2.printList();
        prototype.printList();
    }
        
}
