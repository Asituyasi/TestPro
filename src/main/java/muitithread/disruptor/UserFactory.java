package muitithread.disruptor;

import com.lmax.disruptor.EventFactory;
import muitithread.User;

/**
 * desc :
 * Created by tiantian on 2018/11/3
 */
public class UserFactory implements EventFactory<User> {
    
    public User newInstance() {
        return new User();
    }
}
