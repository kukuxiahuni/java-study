package com.test.concurrency;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @program: java-study
 * @description:
 * @author: kukuxiahuni
 * @create: 2019-01-16 16:17
 **/
public class LockDemo {

    private final static Lock LOCK = new ReentrantLock();
    private int value;

    /**
     * 设置值
     *
     * @param value
     */
    public void setValue(int value) {

        LOCK.lock();
        try {
            this.value = value;
        } finally {
            LOCK.unlock();
        }
    }

    /**
     * 获取值
     * @return
     */
    public int getValue() {
        LOCK.lock();
        try {
            return this.value;
        } finally {
            LOCK.unlock();
        }
    }
}
