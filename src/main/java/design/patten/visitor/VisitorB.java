package design.patten.visitor;

/**
 * desc : 访问者B
 * Created by tiantian on 2018/9/15
 */
public class VisitorB implements Visitor{
    private String name = "VisitorB";
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
