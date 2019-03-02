package design.patten.interpreter;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * desc : 加减法计算器
 * Created by tiantian on 2018/9/30
 */
public class Calculator {
    
    private Expression expression;

    public Calculator(String exp) {
        char[] charArray = exp.toCharArray();
        Stack<Expression> stack = new Stack();
        
        Expression left = null;
        Expression right = null;
        for (int i = 0; i < charArray.length; i++) {
            switch (charArray[i]) {
                case '+' : {
                    left = stack.pop();
                    right = new VarExpression(String.valueOf(charArray[++i]));
                    stack.push(new AddExpression(left, right));
                    break;
                }
                case '-' : {
                    left = stack.pop();
                    right = new VarExpression(String.valueOf(charArray[++i]));
                    stack.push(new SubExpression(left, right));
                    break;
                }
                default : {
                    stack.push(new VarExpression(String.valueOf(charArray[i])));
                }
            }
        }
        this.expression = stack.pop();
    }
    
    public void doCompute(Map<String,Object> param) {
        int res = expression.interpret(param);
        System.out.println("Calculete result is : " + res);
    }

    public static void main(String[] args) {
        Calculator calculator = new Calculator("a-b");
        Map<String,Object> param = new HashMap<>();
        param.put("a", 2);
        param.put("b",3);
        
        calculator.doCompute(param);
    }
}
