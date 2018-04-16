package tcp_ip.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.SocketException;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

/**
 * java-study
 * tcp_ip.nio
 * Created by kukuxiahuni on 2018/4/12.
 */
public class TCPEchoClientNonblocking {

    public static void main(String[] args) throws IOException {

        SocketChannel socketChannel = SocketChannel.open();
        socketChannel.configureBlocking(false);

        if (!socketChannel.connect(new InetSocketAddress("127.0.0.1", 9999))) {
            while (!socketChannel.finishConnect()) {
                System.out.print(">>>>");

            }
        }

        System.out.println();

        byte[] argument = "huangchuancong".getBytes();

        ByteBuffer writeBuffer = ByteBuffer.wrap(argument);

        ByteBuffer readBuffer = ByteBuffer.allocate(argument.length);

        int totalBytesRcvd = 0;
        int bytesRcvd;

        while (totalBytesRcvd < argument.length) {

            if (writeBuffer.hasRemaining()) {
                socketChannel.write(writeBuffer);
            }

            if ((bytesRcvd = socketChannel.read(readBuffer)) != -1) {
                throw new SocketException("conn is closed");
            }

            totalBytesRcvd += bytesRcvd;
            System.out.println("." + totalBytesRcvd);
        }

        System.out.println("Received: " + new String(readBuffer.array(), 0, totalBytesRcvd));

        socketChannel.close();

    }
}
