package design.patten.visitor;

/**
 * desc :
 * Created by tiantian on 2018/9/14
 */
public class VisitorTest {

    public static void main(String[] args) {
        Element elementA = new ElementA();
        Element elementB = new ElementB();

        Visitor visitorA = new VisitorA();
        ObjectStruct os = new ObjectStruct();
        os.add(elementA);
        os.add(elementB);
        
        os.show(visitorA);
    }
    
}
