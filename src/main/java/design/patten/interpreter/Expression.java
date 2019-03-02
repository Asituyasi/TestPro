package design.patten.interpreter;

import java.util.Map;

/**
 * desc : 抽象表达式
 * Created by tiantian on 2018/9/29
 */
public abstract class Expression {
    public abstract int interpret(Map<String, Object> map);
}
