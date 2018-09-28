package tcp_ip.reactor;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.Iterator;
import java.util.Objects;

/**
 * Created by kukuxiahuni on 2018/5/28.
 * 1. 建立客户端连接
 * 2. 事件分发
 * 3. Acceptor：接受连接事件
 */
public class Reactor implements Runnable {

    private final ServerSocketChannel serverSocketChannel;
    private final Selector selector;

    public Reactor() throws IOException {
        //1 打开选择器
        this.selector = Selector.open();
        //2. 打开通道
        this.serverSocketChannel = ServerSocketChannel.open();
        //3. 绑定端口
        this.serverSocketChannel.socket().bind(new InetSocketAddress(12345));
        //4. 设置为非阻塞模式
        this.serverSocketChannel.configureBlocking(false);
        //5. 注册兴趣事件
        this.serverSocketChannel.register(this.selector, SelectionKey.OP_ACCEPT).attach(new Acceptor());


    }

    public void run() {

        while (!Thread.interrupted()) {
            try {
                if (this.selector.select() == 0) {
                    continue;
                }

                Iterator<SelectionKey> iterator = selector.keys().iterator();
                while (iterator.hasNext()) {
                    dispatch(iterator.next());
                    iterator.remove();
                }
            } catch (IOException e) {
//                e.printStackTrace();
            }
        }

    }

    private final static void dispatch(SelectionKey key) {

        Runnable runnable = (Runnable) key.attachment();
        if (Objects.nonNull(runnable)) {
            runnable.run();
        }
    }

    private final class Acceptor implements Runnable{

        public void run() {
            try {
                SocketChannel socketChannel = serverSocketChannel.accept();
                if (Objects.nonNull(socketChannel)) {
                    //
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public final static class Handler implements Runnable {

        private final static int READING = 0, SENDING = 1;

        final SocketChannel socketChannel;
        final SelectionKey selectionKey;
        ByteBuffer input = ByteBuffer.allocate(1024);
        ByteBuffer output = ByteBuffer.allocate(1024);

        public Handler(SocketChannel socketChannel, Selector selector) throws ClosedChannelException {
            this.socketChannel = socketChannel;
            //事件0是什么事件？
            this.selectionKey = this.socketChannel.register(selector, 0, this);
            this.selectionKey.interestOps(SelectionKey.OP_READ);
            selector.wakeup();//唤醒调用该Selector.select方法的线程，并立即返回。
        }

        int status = 0;

        boolean ifInputComplete() {
            return false;
        }
        boolean ifOutputComplete() {
            return false;
        }

        void process() {

        }

        @Override
        public void run() {

            try {
                if (status == READING) {
                    read();
                } else if (status == SENDING) {
                    send();
                }
            } catch (Exception e) {

            }

        }

        public void read() throws IOException {
            this.socketChannel.read(input);

            if (ifInputComplete()) {
                process();
                status = SENDING;
                selectionKey.interestOps(SelectionKey.OP_WRITE);
            }
        }

        public void send() throws IOException {
            this.socketChannel.write(output);

            if (ifOutputComplete()) {
                selectionKey.cancel();

            }
        }
    }

//    public static void main(String[] args) {
//        System.out.println(1<<0);
//    }
}
