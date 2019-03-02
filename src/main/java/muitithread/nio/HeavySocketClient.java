package muitithread.nio;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.LockSupport;

/**
 * desc :
 * Created by tiantian on 2018/11/4
 */
public class HeavySocketClient {
    private static ExecutorService tp = Executors.newCachedThreadPool();
    private static final int sleet_time = 1000*1000*1000;
    public static class EchoClient implements Runnable {
        @Override
        public void run() {
            Socket client = null;
            PrintWriter writer = null;
            BufferedReader reader = null;
            
            client = new Socket();
            try {
                client.connect(new InetSocketAddress(InetAddress.getLocalHost(), 8000));
                writer = new PrintWriter(client.getOutputStream());
                writer.println("H");
                LockSupport.parkNanos(sleet_time);////
                writer.println("e");
                LockSupport.parkNanos(sleet_time);////
                writer.println("l");
                LockSupport.parkNanos(sleet_time);////
                writer.println("l");
                LockSupport.parkNanos(sleet_time);////
                writer.println("o");
                LockSupport.parkNanos(sleet_time);////
                writer.println("!");
                LockSupport.parkNanos(sleet_time);////
                writer.println();
                writer.flush();
                
                reader = new BufferedReader(new InputStreamReader(client.getInputStream()));
                System.out.println("from server:" + reader.readLine());
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    if (writer != null) writer.close();
                    if (reader != null) reader.close();
                    if (client != null) client.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        EchoClient ec = new EchoClient();
        for (int i = 0; i < 10; i++) {
            tp.execute(ec);
        }
    }
}
