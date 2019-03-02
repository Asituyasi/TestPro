package muitithread.disruptor;

import com.lmax.disruptor.WorkHandler;
import muitithread.User;

/**
 * desc :
 * Created by tiantian on 2018/11/3
 */
public class Consumer implements WorkHandler<User> {
    @Override
    public void onEvent(User user) throws Exception {
        System.out.println("Thread "+ Thread.currentThread().getId() + " get a user object");
    }
}
