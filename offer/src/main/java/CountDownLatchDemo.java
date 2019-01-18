import java.util.concurrent.CountDownLatch;

/**
 * @program: java-study
 * @description: 参考： http://www.blogjava.net/xylz/archive/2010/07/09/325612.html
 * @author: kukuxiahuni
 * @create: 2019-01-18 16:26
 **/
public class CountDownLatchDemo {

    private final CountDownLatch startLatch = new CountDownLatch(1);
    private final CountDownLatch runLatch = new CountDownLatch(5);


    public void testCountDownLatch() {
        for (int i = 0; i < 5; ++i) {
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        startLatch.await();
                        System.out.println("do");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } finally {
                        runLatch.countDown();
                    }
                }
            });

            thread.start();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        CountDownLatchDemo countDownLatchDemo = new CountDownLatchDemo();
        countDownLatchDemo.testCountDownLatch();
        countDownLatchDemo.startLatch.countDown();
        countDownLatchDemo.runLatch.await();
        System.out.println("done");
    }


}
