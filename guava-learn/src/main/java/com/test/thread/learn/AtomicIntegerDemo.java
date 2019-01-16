package com.test.thread.learn;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/**
 * @program: java-study
 * @description:
 * @author: kukuxiahuni
 * @create: 2019-01-16 15:32
 * @since <p>fafa
 **/
public class AtomicIntegerDemo {

    /**
     * 通过反射方式修改Java中的字段
     * 1. 只能修改public，protected和默认
     * 2. 只能修改被volatile修饰的字段
     *
     * @param fileName
     * @return
     */
    public AtomicIntegerFieldUpdater<Demo> getUpdater(String fileName) {
        return AtomicIntegerFieldUpdater.newUpdater(Demo.class, fileName);
    }

    void doit() {
        Demo data = new Demo();
        System.out.println("3 ==> " + getUpdater("b").incrementAndGet(data));
        System.out.println("2 ==> " + getUpdater("c").decrementAndGet(data));
        System.out.println(data);
    }

    public static void main(String[] args) {
        AtomicIntegerDemo demo = new AtomicIntegerDemo();
        demo.doit();
    }


    private final static class Demo {
        private volatile int anInt;
        public volatile int b;
        protected volatile int c;

        public int getAnInt() {
            return anInt;
        }

        public void setAnInt(int anInt) {
            this.anInt = anInt;
        }

        public int getB() {
            return b;
        }

        public void setB(int b) {
            this.b = b;
        }

        public int getC() {
            return c;
        }

        public void setC(int c) {
            this.c = c;
        }

        @Override
        public String toString() {
            return "Demo{" +
                    "anInt=" + anInt +
                    ", b=" + b +
                    ", c=" + c +
                    '}';
        }
    }
}
