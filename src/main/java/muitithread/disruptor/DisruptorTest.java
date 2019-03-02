package muitithread.disruptor;

import com.lmax.disruptor.BlockingWaitStrategy;
import com.lmax.disruptor.RingBuffer;
import com.lmax.disruptor.dsl.Disruptor;
import com.lmax.disruptor.dsl.ProducerType;
import muitithread.User;

import java.nio.ByteBuffer;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * desc : 
 * Created by tiantian on 2018/11/3
 */
public class DisruptorTest {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService service = Executors.newCachedThreadPool();
        UserFactory factory = new UserFactory();
        int bufferSize = 1024;
        Disruptor<User> disruptor = new Disruptor(factory,
                bufferSize,
                service,
                ProducerType.MULTI,
                new BlockingWaitStrategy());
        
        disruptor.handleEventsWithWorkerPool(
                new Consumer(),
                new Consumer(),
                new Consumer(),
                new Consumer());
        
        disruptor.start();

        RingBuffer<User> ringBuffer = disruptor.getRingBuffer();
        Procucer procucer = new Procucer(ringBuffer);
        ByteBuffer bb = ByteBuffer.allocate(8);
        for (int i = 0; i < 5; i++) {
            bb.putInt(0,i);
            procucer.pushData(bb);
            Thread.sleep(1000);
            System.out.println("add data "+i);
        }

    }
}
