import java.util.Random;
import java.util.concurrent.*;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @program: java-study
 * @description: 生产者消费者队列：阻塞性读取
 * @author: kukuxiahuni
 * @create: 2019-01-18 15:30
 **/
public class ProducerQueue<T> {

    private final static int CPU = Runtime.getRuntime().availableProcessors();

    private final T[] items;
    private final int size;
    private int tail, head, count;

    private final Lock lock = new ReentrantLock();
    private Condition full = lock.newCondition();
    private Condition empty = lock.newCondition();

    private final static ExecutorService EXECUTOR_SERVICE = initExecutorPool();


    public ProducerQueue(int size) {
        this.count = 0;
        this.tail = 0;
        this.head = 0;
        this.size = size;
        this.items = (T[]) new Object[size];
    }

    /**
     * 存放数据
     *
     * @param value
     */
    public void put(T value) {

        lock.lock();
        try {
            while (count >= items.length) {
                full.await();
            }
            System.out.println("写入： " + value);
            items[tail++] = value;
            ++count;
            if (tail >= size) {
                tail = 0;
            }
            empty.signalAll();

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }

    }

    /**
     * 获取
     */
    public T get() {
        lock.lock();
        try {

            System.out.println("取出count=" + count);

            while (count == 0) {
                empty.await();
            }

            T value = this.items[head++];
            System.out.println("去除： " + value);
            --count;
            if (head >= size) {
                head = 0;
            }
            full.signalAll();
            return value;


        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
        return null;
    }

    /**
     * 构造线程池
     *
     * @return
     */
    private final static ExecutorService initExecutorPool() {

        ThreadFactory threadFactory = new ThreadFactory() {
            @Override
            public Thread newThread(Runnable r) {
                Thread thread = new Thread(r);
                thread.setDaemon(true);
                thread.setName("黄大仙");
                return thread;
            }
        };

        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(CPU, 2 * CPU + 1, 100, TimeUnit.MILLISECONDS,
                new LinkedBlockingDeque<>(1000), threadFactory);

        return threadPoolExecutor;

    }


    /**
     * 消费者
     */
    private final static class Producer implements Runnable {

        ProducerQueue<Integer> producerQueue;

        Random random = new Random(100);

        private volatile boolean flag = true;

        public Producer(ProducerQueue<Integer> producerQueue) {
            this.producerQueue = producerQueue;
        }

        @Override
        public void run() {

            while (flag && !Thread.interrupted()) {
                this.producerQueue.put(random.nextInt(100));
            }

        }

        public void setFlag(boolean flag) {
            this.flag = flag;
        }
    }


    /**
     * 消费者
     */
    private final static class Consumer implements Runnable {

        ProducerQueue<Integer> producerQueue;


        private volatile boolean flag = true;

        public Consumer(ProducerQueue<Integer> producerQueue) {
            this.producerQueue = producerQueue;
        }

        @Override
        public void run() {

            while (flag && !Thread.interrupted()) {
                System.out.println("消费者： " + this.producerQueue.get());
            }

        }

        public void setFlag(boolean flag) {
            this.flag = flag;
        }
    }

    public static void main(String[] args) {

        ProducerQueue<Integer> producerQueue = new ProducerQueue<>(10);
//        producerQueue.put(2);
        EXECUTOR_SERVICE.execute(new Producer(producerQueue));
        EXECUTOR_SERVICE.execute(new Producer(producerQueue));
        EXECUTOR_SERVICE.execute(new Consumer(producerQueue));

//        EXECUTOR_SERVICE.shutdown();

    }

}
