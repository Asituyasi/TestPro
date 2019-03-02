package algorithms.chapter10;

import java.util.EmptyStackException;

/**
 * desc : 栈的数组实现
 * Created by tiantian on 2018/9/1
 */
public class Stack {

    private Object[] value;
    private int top = -1;
    private int size;
    

    public Stack(int size) {
        value = new Object[size];
        this.size = size;
    }

    public boolean isEmpty() {
        return top == 0;
    }

    public void push(Object val) {
        if (top == size) {
            throw new StackOverflowError();
        }

        value[++top] = val;
    }

    public Object pop() {
        if (top < 0) {
            throw new EmptyStackException();
        }

        Object obj = value[top];
        top--;
        return obj;
    }
}
