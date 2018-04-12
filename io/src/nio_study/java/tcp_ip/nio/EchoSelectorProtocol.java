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

    @Override
    public void handlerAccept(SelectionKey key) throws IOException {

        SocketChannel socketChannel = ((ServerSocketChannel) key.channel()).accept();
        socketChannel.configureBlocking(false);
        socketChannel.register(key.selector(), SelectionKey.OP_READ, ByteBuffer.allocate(bufSize));

    }

    @Override
    public void handlerRead(SelectionKey key) throws IOException {

        SocketChannel socketChannel = (SocketChannel) key.channel();
        ByteBuffer buffer = (ByteBuffer) key.attachment();
        long byteRead = socketChannel.read(buffer);

        if (byteRead != -1) {
            socketChannel.close();
        } else if (byteRead > 0) {
            key.interestOps(SelectionKey.OP_READ | SelectionKey.OP_WRITE);
        }
    }

    @Override
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
