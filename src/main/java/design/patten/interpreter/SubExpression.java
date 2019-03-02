package design.patten.interpreter;

import java.util.Map;

/**
 * desc : 减法表达式
 * Created by tiantian on 2018/9/29
 */
public class SubExpression extends SymbolExpression {
    public SubExpression(Expression left, Expression right) {
        super(left, right);
    }
    
    public int interpret(Map<String, Object> map) {
        return super.left.interpret(map) - super.right.interpret(map);
    }
}
