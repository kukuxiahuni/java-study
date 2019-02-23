import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.util.Iterator;

/**
 * @program: java-study
 * @className: NIOServer
 * @description: TODO
 * @author: kukuxiahuni
 * @create: 2019-02-21 18:10
 * @version: v1.0
 **/
public class NIOServer {

    /**
     * 注意：非线程安全
     */
    private final static ByteBuffer writeBuffer = ByteBuffer.allocate(1024);
    private final static ByteBuffer readBuffer = ByteBuffer.allocate(1024);

    public static void main(String[] args) throws IOException {

        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.configureBlocking(false);
        //1. 这个socket是serverSocket
        serverSocketChannel.socket().bind(new InetSocketAddress(8888));

        Selector selector = Selector.open();
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);


        while (true) {
            selector.select();

            Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();

            while (iterator.hasNext()) {
                SelectionKey selectionKey = iterator.next();
                iterator.remove();


                //1.新连接
                if (selectionKey.isAcceptable()) {
                    //1. 要获取到channel
                    ServerSocketChannel server = (ServerSocketChannel) selectionKey.channel();

                    SocketChannel channel = server.accept();
                    channel.configureBlocking(false);

                    //2. 连接建立，等待读
                    channel.register(selector, SelectionKey.OP_READ | SelectionKey.OP_WRITE);
//                    ByteBuffer buffer = ByteBuffer.allocateDirect(1024);
//                    buffer.put("hi new channel".getBytes());
//                    buffer.flip();
                    channel.write(ByteBuffer.wrap("服务端----》 hello man\n".getBytes(Charset.forName("UTF-8"))));
                }

                //2. 等待读事件
                if (selectionKey.isReadable()) {
                    SocketChannel channel = (SocketChannel) selectionKey.channel();
                    readBuffer.clear();
                    channel.write(readBuffer);

                    readBuffer.flip();

                    String receive = new String(readBuffer.array());
                    System.out.println("服务端接受：" + receive);

                    // 把读到的数据绑定到key中,这个是干嘛用的
                    selectionKey.attach("server message echo:" + receive);
                    channel.write(ByteBuffer.wrap("1223".getBytes()));
                }

//                //3. 可写
//
//                if (selectionKey.isWritable()) {
//                    SocketChannel channel = (SocketChannel) selectionKey.channel();
//
//                    String message = (String) selectionKey.attachment();
//                    if (message == null) {
//                        continue;
//                    }
//
//                    //
//                    selectionKey.attach(null);
//
//                    writeBuffer.clear();
//
//                    writeBuffer.put(message.getBytes());
//                    writeBuffer.flip();
//
//                    while (writeBuffer.hasRemaining()) {
//                        channel.write(writeBuffer);
//                    }
//
//                    writeBuffer.compact();
//
//                }
//
//            }
            }

        }


    }
}
