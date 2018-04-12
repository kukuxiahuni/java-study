package tcp_ip;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

/**
 * ProjectName: data_structure
 * Package: tcp_ip
 * Created by kukuxiahuni on 17/3/3.
 */
public class TcpEchoClient {
    private static int port = 8899;

    public static void main(String[] args) throws IOException {
        Socket socket = new Socket(InetAddress.getLocalHost(), port);

        InputStream inputStream = socket.getInputStream();
        OutputStream outputStream = socket.getOutputStream();

        Scanner scanner = new Scanner(System.in);

        String s = scanner.nextLine();

        byte[] data = s.getBytes();
        outputStream.write(data);

        int total = 0;
        int received = 0;
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(outputStream);

        while (total < s.length()) {

            if ((received = inputStream.read(data, total, data.length - total)) != -1) {
                total += received;
            }
        }

        System.out.println(new String(data));

        System.out.println(total);
        socket.close();

    }
}
