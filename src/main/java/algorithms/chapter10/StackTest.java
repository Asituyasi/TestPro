package algorithms.chapter10;

/**
 * desc : 栈测试
 * Created by tiantian on 2018/9/1
 */
public class StackTest {

    public static void main(String[] args) {
        Stack myStack = new Stack(5);
        myStack.push(1);
        myStack.push(2);
        myStack.push(3);
        myStack.push(4);
        myStack.push(5);
        //myStack.push(6);// Exception in thread "main" java.lang.StackOverflowError

        System.out.println(myStack.pop());
        
    }
}
