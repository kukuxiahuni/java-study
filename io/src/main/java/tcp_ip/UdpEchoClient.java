package tcp_ip;


import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;


/**
 * ProjectName: data_structure
 * Package: tcp_ip
 * Created by kukuxiahuni on 17/3/6.
 */
public class UdpEchoClient {

    public static void main(String[] args) throws IOException {

        DatagramSocket datagramSocket = new DatagramSocket();
        datagramSocket.setSoTimeout(3000);

        byte[] bytes = "黄传聪".getBytes();
        DatagramPacket datagramPacket = new DatagramPacket(bytes, 0, bytes.length, InetAddress.getLocalHost(), 8899);

        DatagramPacket receivePacket = new DatagramPacket(new byte[bytes.length], bytes.length);

        int reties = 0;

        boolean response = false;

        while (!response && reties < 3) {
            datagramSocket.send(datagramPacket);

            datagramSocket.receive(receivePacket);

            if (receivePacket.getAddress().equals(InetAddress.getLocalHost())) {
                response = true;
            } else {
                ++reties;

            }

        }


        if (response) {
            System.out.println(new String(receivePacket.getData()));
        } else {
            System.out.println("no reponse");

        }

        datagramSocket.close();
    }
}
