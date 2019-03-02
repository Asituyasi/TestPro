package test;

import muitithread.User;

/**
 * desc :
 * Created by tiantian on 2018/10/24
 */
public class Main {
    public static final String A = "hello";
    public static final String B = "world";
    
    public static void main(String[] args) {
        User user = new User();
        System.out.println(user.hashCode());
        test(user);
    }
    
    public static void test(User user) {
        System.out.println(user.hashCode());
    }
    
    public static void testObjectHash() {
        int[] a = {1,2,3};
        int[] b = {1,2,3};
        System.out.println("a == b ? " + (boolean)(a==b));

        int hashCode = a.hashCode();
        int hashCode1 = b.hashCode();

        System.out.println(hashCode);
        System.out.println(hashCode1);
    }
}
