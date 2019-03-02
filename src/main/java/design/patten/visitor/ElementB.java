package design.patten.visitor;

/**
 * desc : 元素B
 * Created by tiantian on 2018/9/14
 */
public class ElementB implements Element {
    
    private String property1 = "hello ";

    private String property2 = "world";
    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
        System.out.println(visitor.getName() + " visited ElementB");
    }

    public String getProperty1() {
        return property1;
    }

    public String getProperty2() {
        return property2;
    }
}
