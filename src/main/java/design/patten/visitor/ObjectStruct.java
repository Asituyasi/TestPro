package design.patten.visitor;

import java.util.ArrayList;
import java.util.List;

/**
 * desc : 对象结构
 * Created by tiantian on 2018/9/14
 */
public class ObjectStruct {
    
    private List<Element> elements = new ArrayList<>();
    
    public void add(Element e) {
        elements.add(e);
    }
    
    public void show(Visitor visitor) {
        for (Element e : elements) {
            e.accept(visitor);
        }
    }
}
