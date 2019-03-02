package design.patten.interpreter;

/**
 * desc : 抽象符号表达式
 * Created by tiantian on 2018/9/29
 */
public abstract class SymbolExpression extends Expression {
    protected Expression left;
    protected Expression right;

    public SymbolExpression(Expression left, Expression right) {
        this.left = left;
        this.right = right;
    }
}
