package design.patten.visitor;

/**
 * desc : 元素A
 * Created by tiantian on 2018/9/14
 */
public class ElementA implements Element {
    
    private String property1 = "Hello ";
    
    private String property2 = "World";
    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
        System.out.println(visitor.getName() + " visited ElementA");
    }

    public String getProperty1() {
        return property1;
    }

    public String getProperty2() {
        return property2;
    }
}
