package tcp_ip;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketAddress;

/**
 * ProjectName: data_structure
 * Package: tcp_ip
 * Created by kukuxiahuni on 17/3/3.
 */
public class TcpEchoServer {

    private static int port = 8899;

    private static int bufferSize = 32;

    public static void main(String[] args) throws IOException {
        InputStream inputStream = null;
        OutputStream outputStream = null;
        try{

            int receiveSize = 0;
            byte[] buffer = new byte[bufferSize];

            ServerSocket serverSocket = new ServerSocket(port);

            while (true) {
                Socket clientSocket = serverSocket.accept();

                //获取端地址和端口
                SocketAddress socketAddress = clientSocket.getRemoteSocketAddress();

                inputStream = clientSocket.getInputStream();
                outputStream = clientSocket.getOutputStream();

                while ((receiveSize = inputStream.read(buffer)) != -1) {
                    outputStream.write(buffer);
                }

            }


        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (outputStream != null) {
                outputStream.close();
                outputStream = null;
            }

            if (inputStream != null) {
                inputStream.close();
                inputStream = null;
            }
        }

    }
}
