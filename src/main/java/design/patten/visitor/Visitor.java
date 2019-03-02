package design.patten.visitor;

/**
 * desc : 访问者接口
 * Created by tiantian on 2018/9/14
 */
public interface Visitor {
    
    String getName();
    
    void visit(ElementA e);
    
    void visit(ElementB e);
}
