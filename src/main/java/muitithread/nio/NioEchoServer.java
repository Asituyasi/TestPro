package muitithread.nio;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.nio.channels.spi.SelectorProvider;
import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * desc :
 * Created by tiantian on 2018/11/4
 */
public class NioEchoServer {
    // selector用于处理所有的网络连接
    private static Selector selector;
    // tp中的线程对每一个请求进行处理
    private static ExecutorService tp = Executors.newCachedThreadPool();
    public static Map<Socket,Long> time_stat = new HashMap(10240);

    public static void startServer() throws IOException {
        selector = SelectorProvider.provider().openSelector();
        ServerSocketChannel ssc = ServerSocketChannel.open();
        ssc.configureBlocking(false);
        InetSocketAddress isa = new InetSocketAddress(InetAddress.getLocalHost(), 8000);

        // SelectionKey表示一对Selector和Channel的关系，Channel被关闭时SelectionKey会实效
        SelectionKey acceptKey = ssc.register(selector, SelectionKey.OP_ACCEPT);
        
        for (;;) {
            System.out.println("start up");
            // select()为阻塞方法，如果当前未准备好数据就会等待。
            selector.select();
            Set<SelectionKey> redyKeys = selector.selectedKeys();
            Iterator<SelectionKey> i = redyKeys.iterator();
            long e = 0;
            while (i.hasNext()) {
                SelectionKey sk = i.next();
                i.remove();

                if (sk.isAcceptable()) {
                    doAccept(sk);
                } else if (sk.isValid() && sk.isReadable()) {
                    if (!time_stat.containsKey(((SocketChannel)sk.channel()).socket())) {
                        time_stat.put(((SocketChannel) sk.channel()).socket(), System.currentTimeMillis());
                    }
                    doRead(sk);
                } else if (sk.isValid() && sk.isWritable()) {
                    doWrite(sk);
                    e = System.currentTimeMillis();
                    long b  = time_stat.remove(((SocketChannel)sk.channel()).socket());
                    System.out.println("spend: " + (e-b) + " ms");
                }
            }
        }
    }
    
    public static void doAccept(SelectionKey sk) {
        ServerSocketChannel server = (ServerSocketChannel) sk.channel();
        SocketChannel clientChannel;

        try {
            // 当有新的客户端连接接入时生成新端Channel代表这个连接来进行通信
            clientChannel = server.accept();
            // 设为非阻塞模式，要去系统准备好IO后通知线程（Selector所在线程？）读取或者写入
            clientChannel.configureBlocking(false);
            // 注册
            SelectionKey clientKey = clientChannel.register(selector, SelectionKey.OP_READ);

            EchoClient echoClient = new EchoClient();
            clientKey.attach(echoClient);

            InetAddress clientAddress = clientChannel.socket().getInetAddress();
            System.out.println("Accepted connection from " + clientAddress.getHostAddress() + ".");
        } catch (IOException e) {
            System.out.println("Failed to accept new Client.");
            e.printStackTrace();
        }
    }
    
    public static void doRead(SelectionKey sk) {
        SocketChannel channel = (SocketChannel) sk.channel();
        ByteBuffer bb = ByteBuffer.allocate(8192);
        int len;

        try {
            len = channel.read(bb);
            if (len < 0) {
//                disconnect(bb);
                return;
            }
        } catch (IOException e) {
            System.out.println("Failed to read from client.");
            e.printStackTrace();
            //                disconnect(bb);
            return;
        }
        
        bb.flip();
        tp.execute(new HandleMsg(sk, bb));
    }
    
    public static void doWrite(SelectionKey sk) {
        SocketChannel channel = (SocketChannel) sk.channel();
        EchoClient echoClient = (EchoClient) sk.attachment();
        LinkedList<ByteBuffer> outq = echoClient.getOutputQueue();

        ByteBuffer bb = outq.getLast();
        try {
            int len = channel.write(bb);
            if (len == -1) {
//                disconnet(sk);
                return;
            }
            if (bb.remaining() == 0) {
                // buffer 已经写完
                outq.remove();
            }
        } catch (IOException e) {
            System.out.println("Failed to write to client.");
            e.printStackTrace();
            //                disconnet(sk);
        }
        if (outq.size() == 0) {
            sk.interestOps(SelectionKey.OP_READ);
        }
    }
    
    static class EchoClient {
        private LinkedList<ByteBuffer> outq;

        public EchoClient() {
            this.outq = outq = new LinkedList<>();
        }
        public LinkedList<ByteBuffer> getOutputQueue() {
            return outq;
        }
        public void enqueue(ByteBuffer bb) {
            outq.addFirst(bb);
        }
    }
    
    static class HandleMsg implements Runnable {
        SelectionKey sk;
        ByteBuffer bb;

        public HandleMsg(SelectionKey sk, ByteBuffer bb) {
            this.sk = sk;
            this.bb = bb;
        }

        @Override
        public void run() {
            EchoClient echoClient = (EchoClient) sk.attachment();
            echoClient.enqueue(bb);
            sk.interestOps(SelectionKey.OP_READ | SelectionKey.OP_WRITE);
            // 强迫selector立即返回
            selector.wakeup();
        }
    }
    
    public static void main(String[] args) throws IOException {
        startServer();
    }
}
