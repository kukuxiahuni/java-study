import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @program: java-study
 * @description:
 * @author: kukuxiahuni
 * @create: 2019-01-23 16:22
 * 1. 信号量只是在信号不够的时候挂起线程，但是并不能保证信号量足够的时候获取对象和返还对象是线程安全的，
 **/
public class ObjectPool<T> {

    public interface ObjectFactory<T> {
        T makeObject();
    }

    private final class Node {
        T obj;
        Node next;
    }

    final int capacity;

    final ObjectFactory<T> factory;

    final Lock lock = new ReentrantLock();

    final Semaphore semaphore;

    private Node head;

    private Node tail;

    /**
     * 构造函数
     *
     * @param capacity
     * @param factory
     */
    public ObjectPool(int capacity, ObjectFactory<T> factory) {
        this.capacity = capacity;
        this.factory = factory;
        this.semaphore = new Semaphore(this.capacity);
        this.head = null;
        this.tail = null;
    }

    /**
     * 获取对象
     *
     * @return
     * @throws InterruptedException
     */
    public T getObject() throws InterruptedException {
        semaphore.acquire();
        return getNextObject();
    }

    /**
     * 释放对象
     * @param t
     */
    public void returnObject(T t) {
        returnObjectToPool(t);
        semaphore.release();
    }

    /**
     * 这个地方，直接返回了对象
     * @return
     */
    private T getNextObject() {
        lock.lock();
        try {
            if (head == null) {
                return factory.makeObject();
            } else {
                Node ret = head;
                head = head.next;
                if (head == null) {
                    tail = null;
                }
                //help GC
                ret.next = null;
                return ret.obj;
            }
        } finally {
            lock.unlock();
        }
    }



    private void returnObjectToPool(T t) {
        lock.lock();
        try {
            Node node = new Node();
            node.obj = t;
            if (tail == null) {
                head = tail = node;
            } else {
                tail.next = node;
                tail = node;
            }

        } finally {
            lock.unlock();
        }
    }




}
