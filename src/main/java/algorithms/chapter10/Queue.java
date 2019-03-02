package algorithms.chapter10;

/**
 * desc : 队列的数组实现
 * Created by tiantian on 2018/9/1
 */
public class Queue {
    private Object[] queue;
    private int length;
    private int head = 0;
    private int tail = 0;

    public Queue(int len) {
        this.length = len;
        queue = new Object[len];
    }

    public void enQueue(Object obj) {
        if (tail == length) {
            tail = 0;
        }
        queue[tail++] = obj;
    }
    
    public Object deQueue() {
        if (queue[head] == null) {
            return null;
        }
        
        Object temp = queue[head];
        if (head == length) {
            head = 0;
        } else {
            head++;
        }
        
        return temp;
    }
}
