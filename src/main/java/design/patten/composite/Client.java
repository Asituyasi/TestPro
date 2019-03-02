package design.patten.composite;


public class Client {
    public static void main(String[] args) {
        Component father = new Composite();
        father.add(new Composite());
        father.display();
        
        Component leaf = new Leaf();
        leaf.display();
        father.add(leaf);
    }
    // output:
    // I'm Composite, i have sub Composite
    // I'm Leaf,i have no Composite
}
