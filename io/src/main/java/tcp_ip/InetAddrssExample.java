package tcp_ip;

import java.net.*;
import java.util.Enumeration;


/**
 * ProjectName: data_structure
 * Package: tcp_ip
 * Created by kukuxiahuni on 17/3/1.
 */
public class InetAddrssExample {

    public static void main(String[] args) {

        try {

            Enumeration<NetworkInterface> enumeration = NetworkInterface.getNetworkInterfaces();

            while (null != enumeration && enumeration.hasMoreElements()) {
                NetworkInterface networkInterface = enumeration.nextElement();
                System.out.println(networkInterface.getName());

                Enumeration<InetAddress> inetAddressEnumeration = networkInterface.getInetAddresses();

                while (null != inetAddressEnumeration && inetAddressEnumeration.hasMoreElements()) {
                    InetAddress inetAddress = inetAddressEnumeration.nextElement();


                    if (inetAddress instanceof Inet4Address) {
                        System.out.printf("v4: %s\n", inetAddress.getHostName());
                    } else if (inetAddress instanceof Inet6Address) {
                        System.out.printf("v6: %s\n", inetAddress.getHostName());
                    }
                }
            }


        } catch (SocketException e) {
            e.printStackTrace();
        }
    }
}
