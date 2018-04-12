package tcp_ip;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 * ProjectName: data_structure
 * Package: tcp_ip
 * Created by kukuxiahuni on 17/3/6.
 */
public class UdpEchoServer {

    public static void main(String[] args) throws IOException {
        DatagramSocket datagramSocket = new DatagramSocket(8899);

        DatagramPacket datagramPacket = new DatagramPacket(new byte[255], 255);

        while (true) {
            datagramSocket.receive(datagramPacket);

            System.out.println(datagramPacket.getAddress().getHostAddress() + ", " + datagramPacket.getPort());
            datagramSocket.send(datagramPacket);
        }
    }
}
