package design.patten.templatemethod;

/**
 * Created by tiantian on 2018/7/28
 */
public abstract class AbstractTemplateMethod {
    
    public void templateMethod() {
        implementedMethod();
        abstractMethod();
        hookMethod();
        // ... more than method invoke
    }
    public void anotherTemplateMethod() {
        // do other things
    }
    
    public abstract void abstractMethod();
    
    public void hookMethod() {}
    
    public void implementedMethod() {
        System.out.println("I have been implemented in TemplateMethod class.");
    }
    
    // ... more than method abstract or implemented.
}
