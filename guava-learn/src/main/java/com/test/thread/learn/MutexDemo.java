package com.test.thread.learn;

import java.io.Serializable;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * @program: java-study
 * @description:
 * @author: kukuxiahuni
 * @create: 2019-01-17 10:50
 * 互斥锁demo
 **/
public class MutexDemo implements Lock, Serializable {

    private final static Sync SYNC = new Sync();

    @Override
    public void lock() {
        SYNC.acquire(1);
    }

    @Override
    public void lockInterruptibly() throws InterruptedException {
        SYNC.acquireInterruptibly(1);
    }

    @Override
    public boolean tryLock() {
        return SYNC.tryAcquire(1);
    }

    @Override
    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        return SYNC.tryAcquireNanos(1, unit.toNanos(time));
    }

    @Override
    public void unlock() {
        SYNC.tryRelease(0);

    }

    @Override
    public Condition newCondition() {
        return SYNC.newCondition();
    }

    /**
     * 使用0或者1表示是否可以获取锁
     */
    private final static class Sync extends AbstractQueuedSynchronizer {

        @Override
        protected boolean tryAcquire(int arg) {
            assert arg == 1;

            if (compareAndSetState(0, 1)) {
                setExclusiveOwnerThread(Thread.currentThread());
                return true;
            }

            return false;
        }

        @Override
        protected boolean tryRelease(int arg) {

            assert arg == 0;

            if (getState() == 0) {
                throw new IllegalStateException();
            }
            setExclusiveOwnerThread(null);
            setState(0);


            return true;
        }

        @Override
        protected boolean isHeldExclusively() {
            return super.getState() == 1;
        }

        Condition newCondition() {
            return new ConditionObject();
        }
    }

}
