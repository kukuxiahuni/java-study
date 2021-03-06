package tcp_ip.nio;


import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

/**
 * java-study
 * tcp_ip.nio
 * Created by kukuxiahuni on 2018/4/12.
 */
public class EchoSelectorProtocol implements TCPProtocol {

    private int bufSize;

    public EchoSelectorProtocol(int bufSize) {
        this.bufSize = bufSize;
    }

    public void handlerAccept(SelectionKey key) throws IOException {

        SocketChannel socketChannel = ((ServerSocketChannel) key.channel()).accept();
        socketChannel.configureBlocking(false);
        socketChannel.register(key.selector(), SelectionKey.OP_READ, ByteBuffer.allocate(bufSize));

    }

    public void handlerRead(SelectionKey key) throws IOException {

        SocketChannel socketChannel = (SocketChannel) key.channel();
        ByteBuffer buffer = (ByteBuffer) key.attachment();
        int byteRead = socketChannel.read(buffer);

        System.out.println(new String(buffer.array(), "utf-8"));
        //如果底层信道关闭，则关闭
        if (byteRead == -1) {
            socketChannel.close();

        } else if (byteRead > 0) {
            //接收完成，标记为可写
            key.interestOps(SelectionKey.OP_WRITE);
        }
    }

    public void handlerWrite(SelectionKey key) throws IOException {

        ByteBuffer buffer = (ByteBuffer) key.attachment();

        buffer.flip();
        SocketChannel socketChannel = (SocketChannel) key.channel();
        socketChannel.write(buffer);

        if (!buffer.hasRemaining()) {
            key.interestOps(SelectionKey.OP_READ);
        }
        buffer.compact();
    }
}
