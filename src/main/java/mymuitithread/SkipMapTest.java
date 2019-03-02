package mymuitithread;

import java.util.Random;
import java.util.concurrent.ConcurrentSkipListMap;

/**
 * desc :
 * Created by tiantian on 2018/10/26
 */
public class SkipMapTest {
    
    public static void main(String[] args) {
        ConcurrentSkipListMap<Integer, String> sMap = new ConcurrentSkipListMap<>();
        for (int i = 0; i < 10; i++) {
            sMap.put(new Random().nextInt(100), String.valueOf(new Random().nextInt(100)));
        }
        
        sMap.forEach((a,b) -> System.out.println(a + " : " + b) );
        
    }
}
