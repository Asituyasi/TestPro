package jvm;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tiantian on 2019/2/15
 */
public class RunTimeConstPoolOutOfMemoryTest {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        int i = 0;
        while (true) {
            list.add(String.valueOf(i++).intern());
        }
    }
}
