package muitithread.disruptor;

import com.lmax.disruptor.RingBuffer;
import muitithread.User;

import java.nio.ByteBuffer;

/**
 * desc :
 * Created by tiantian on 2018/11/3
 */
public class Procucer {
    private RingBuffer<User> ringBuffer;

    public Procucer(RingBuffer<User> ringBuffer) {
        this.ringBuffer = ringBuffer;
    }
    
    public void pushData(ByteBuffer bb) {
        // 获得下一个序号
        long sequence = ringBuffer.next(); 
        try {
            User user = ringBuffer.get(sequence);
            user.setId(bb.getInt(0));
        } finally {
            ringBuffer.publish(sequence);
        }
        
    }
}
