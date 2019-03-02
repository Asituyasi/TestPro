package algorithms.chapter10;

/**
 * desc : 队列测试
 * Created by tiantian on 2018/9/1
 */
public class QueueTest {
    public static void main(String[] args) {
        Queue queue = new Queue(6);
        queue.enQueue(1);
        queue.enQueue(2);
        System.out.println(queue.deQueue());
        System.out.println(queue.deQueue());
        System.out.println(queue.deQueue());

        queue.enQueue(3);
        System.out.println(queue.deQueue());
    }
}
