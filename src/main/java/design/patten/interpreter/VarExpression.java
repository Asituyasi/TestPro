package design.patten.interpreter;

import java.util.Map;

/**
 * desc : 变量表达式
 * Created by tiantian on 2018/9/29
 */
public class VarExpression extends Expression {
    
    private String key;

    public VarExpression(String key) {
        this.key = key;
    }
    
    public int interpret(Map<String, Object> map) {
        return (int) map.get(key);
    }
}
