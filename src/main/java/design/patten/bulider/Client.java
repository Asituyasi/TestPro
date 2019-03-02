package design.patten.bulider;

import design.patten.prototype.Prototype;

/**
 * Created by tiantian on 2018/6/18.
 */
public class Client {

    public static void main(String[] args) throws CloneNotSupportedException {
        Prototype prototype = new Prototype();
        Prototype prototype2 = prototype.clone();
        prototype2.list.add("word");
        
        System.out.println(prototype.list.toString());
        System.out.println(prototype2.list.toString());
    }
    
}
