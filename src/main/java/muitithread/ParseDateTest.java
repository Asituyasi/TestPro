package muitithread;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * desc :
 * Created by tiantian on 2018/10/30
 */
public class ParseDateTest {
    private static ThreadLocal<SimpleDateFormat> tl = new ThreadLocal<>();
    static class ParseDate implements Runnable{
        int i;

        public ParseDate(int i) {
            this.i = i;
        }

        @Override
        public void run() {
            try {
                if (tl.get() == null) {
                    // 在应用层面保证每个线程有一个SimpleDateFormat对象
                    tl.set(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
                }
                Date date = tl.get().parse("2015-03-29 19:29:" + i%60);
                System.out.println(i + " : " + date);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        ExecutorService es = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 10; i++) {
            es.execute(new ParseDate(i));
        }
    }
}
