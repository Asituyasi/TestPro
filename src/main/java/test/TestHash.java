package test;

import muitithread.User;

/**
 * desc :
 * Created by tiantian on 2018/10/20
 */
public class TestHash {
    public static void main(String[] args) {
        User user = new User();
        User user2 = new User();

        System.out.println(user.equals(user2));
        System.out.println("user hash : "+user.hashCode());
        System.out.println("user1 hash "+user2.hashCode());
    }
}
