import java.sql.SQLOutput;
import java.util.concurrent.CountDownLatch;

/**
 * @program: java-study
 * @description:
 * @author: kukuxiahuni
 * @create: 2019-02-18 09:26
 **/
public class CountDownLatchTest {

    public static void main(String[] args) {

        CountDownLatch gateway = new CountDownLatch(1);

        for (int i = 0; i < 3; ++i) {

            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        gateway.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("yes, I am running");
                }
            });

            thread.start();

        }

        gateway.countDown();

        System.out.println("yes run over");

    }
}
