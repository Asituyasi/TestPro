package jvm;

import sun.misc.Unsafe;

import java.lang.reflect.Field;
import java.nio.ByteBuffer;

/**
 * Created by tiantian on 2019/2/15
 */
public class DirectMemoryOutTest {
    
    private static final int _1M = 1024*1024;

    public static void main(String[] args) throws IllegalAccessException {
        Field unsafeField = Unsafe.class.getDeclaredFields()[0];
        unsafeField.setAccessible(true);
        Unsafe unsafe = (Unsafe) unsafeField.get(null);
        while (true) {
            System.out.println("allocated");
            ByteBuffer.allocateDirect(_1M);
        }
    }
}
