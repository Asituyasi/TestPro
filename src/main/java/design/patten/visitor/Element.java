package design.patten.visitor;

/**
 * desc : 元素接口
 * Created by tiantian on 2018/9/14
 */
public interface Element {
    
    void accept(Visitor visitor);
}
