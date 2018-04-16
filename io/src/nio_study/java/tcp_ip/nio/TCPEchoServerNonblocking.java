package tcp_ip.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.util.Iterator;

/**
 * java-study
 * tcp_ip.nio
 * Created by kukuxiahuni on 2018/4/12.
 */
public class TCPEchoServerNonblocking {

    private final static int BUFSIZE = 256;
    private final static int TIMEOUT = 3000;

    public static void main(String[] args) throws IOException {

        Selector selector = Selector.open();

        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.socket().bind(new InetSocketAddress("127.0.0.1",9999));

        serverSocketChannel.configureBlocking(false);

        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);


        TCPProtocol tcpProtocol = new EchoSelectorProtocol(BUFSIZE);

        while (true) {

            if (selector.select(TIMEOUT) == 0) {
                System.out.print(".");
                continue;
            }

            Iterator<SelectionKey> keyIterator = selector.selectedKeys().iterator();

            while (keyIterator.hasNext()) {
                SelectionKey key = keyIterator.next();

                if (key.isAcceptable()) {
                    tcpProtocol.handlerAccept(key);
                }

                if (key.isReadable()) {
                    tcpProtocol.handlerRead(key);

                }

                if (key.isValid() && key.isWritable()) {
                    tcpProtocol.handlerWrite(key);
                }

                keyIterator.remove();
            }



        }


    }

}
