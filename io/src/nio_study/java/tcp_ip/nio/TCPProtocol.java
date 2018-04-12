package tcp_ip.nio;

import java.io.IOException;
import java.nio.channels.SelectionKey;

/**
 * java-study
 * tcp_ip.nio
 * Created by kukuxiahuni on 2018/4/12.
 */
public interface TCPProtocol {

    void handlerAccept(SelectionKey key) throws IOException;

    void handlerRead(SelectionKey key) throws IOException;

    void handlerWrite(SelectionKey key) throws IOException;
}
