import java.util.Objects;
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
    private volatile int tail, head, count;

    private final Lock lock = new ReentrantLock();
    //写入信号量
    private Condition notFull = lock.newCondition();
    //读取信号量
    private Condition notEmpty = lock.newCondition();

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
            while (count == items.length) {
                notFull.await();
            }

            T[] array = this.items;
            array[tail] = value;

            if (++tail == items.length) {
                tail = 0;
            }

            System.out.println("写入： " + value);
            ++count;

            notEmpty.signal();

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
                notEmpty.await();
            }

            T[] array = this.items;

            T value = array[head];
            array[head] = null;

            if (++head == items.length) {
                head = 0;
            }
            count--;

            System.out.println("去除： " + value);

            notFull.signal();
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

        ArrayBlockingQueue<Integer> producerQueue;

        Random random = new Random(100);

        private volatile boolean flag = true;

        public Producer(ArrayBlockingQueue<Integer> producerQueue) {
            this.producerQueue = producerQueue;
        }

        @Override
        public void run() {

            while (flag && !Thread.interrupted()) {
                this.producerQueue.offer(random.nextInt(100));
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

        ArrayBlockingQueue<Integer> producerQueue;


        private volatile boolean flag = true;

        public Consumer(ArrayBlockingQueue<Integer> producerQueue) {
            this.producerQueue = producerQueue;
        }

        @Override
        public void run() {

            while (flag && !Thread.interrupted()) {
                Integer integer = null;
                try {
                    integer = this.producerQueue.take();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (Objects.nonNull(integer)) {
                    System.out.println("消费者： " + integer);
                }
            }

        }

        public void setFlag(boolean flag) {
            this.flag = flag;
        }
    }

    public static void main(String[] args) {

        ArrayBlockingQueue<Integer> producerQueue = new ArrayBlockingQueue<>(100);
//        producerQueue.put(2);
//        EXECUTOR_SERVICE.execute(new Producer(producerQueue));
        EXECUTOR_SERVICE.execute(new Producer(producerQueue));
        EXECUTOR_SERVICE.execute(new Consumer(producerQueue));

//        EXECUTOR_SERVICE.shutdown();

    }

}
