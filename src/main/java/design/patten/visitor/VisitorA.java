package design.patten.visitor;

/**
 * desc : 具体访问者A
 * Created by tiantian on 2018/9/14
 */
public class VisitorA implements Visitor {
    
    private String name = "visitorA";
    
    @Override
    public String getName() {
        return name;
    }

    @Override
    public void visit(ElementA e) {
        System.out.println(e.getProperty1() + e.getProperty2());
    }

    @Override
    public void visit(ElementB e) {
        System.out.println(e.getProperty1() + e.getProperty2());
    }
}
