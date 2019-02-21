import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.util.Iterator;

/**
 * @program: java-study
 * @className: NIOClient
 * @description: TODO
 * @author: kukuxiahuni
 * @create: 2019-02-21 18:40
 * @version: v1.0
 **/
public class NIOClient {

    private final static ByteBuffer READ_BUFFER = ByteBuffer.allocate(1024);
    private final static ByteBuffer WRITE_BUFFER = ByteBuffer.allocate(1024);

    public static void main(String[] args) throws IOException {

        SocketChannel socketChannel = SocketChannel.open();
        socketChannel.configureBlocking(false);
        socketChannel.connect(new InetSocketAddress(InetAddress.getLocalHost(), 8888));

        Selector selector = Selector.open();

        socketChannel.register(selector, SelectionKey.OP_CONNECT);


        while (selector.select() > 0) {

            Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();

            while (iterator.hasNext()) {
                SelectionKey selectionKey = iterator.next();
                iterator.remove();

                if (selectionKey.isConnectable()) {
                    SocketChannel channel = (SocketChannel) selectionKey.channel();

                    //1. 如果处于连接中，等待连接完成
                    if (channel.isConnectionPending()) {
                        channel.finishConnect();
                    }

                    //2. 设置非阻塞
                    channel.configureBlocking(false);

                    channel.write(ByteBuffer.wrap("aaaaa".getBytes()));

                    channel.register(selector, SelectionKey.OP_READ);
                }
                if (selectionKey.isReadable()) {
                    SocketChannel readChannel = (SocketChannel) selectionKey.channel();

                    READ_BUFFER.clear();

                    readChannel.write(READ_BUFFER);
                    READ_BUFFER.flip();

                    String receiveData= Charset.forName("UTF-8").decode(READ_BUFFER).toString();

                    System.out.println("receive server message:"+receiveData);
                    READ_BUFFER.clear();
                }

                if (selectionKey.isWritable()) {
                    SocketChannel readChannel = (SocketChannel) selectionKey.channel();
                    synchronized(WRITE_BUFFER){
                        WRITE_BUFFER.flip(); //设置写
                        while(WRITE_BUFFER.hasRemaining()){
                            socketChannel.write(WRITE_BUFFER);
                        }
                        WRITE_BUFFER.compact();
                    }
                }

            }

        }


    }
}
