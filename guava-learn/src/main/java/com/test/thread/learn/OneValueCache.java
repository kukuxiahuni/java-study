package com.test.thread.learn;

import java.math.BigInteger;

/**
 * @program: java-study
 * @description:
 * @author: kukuxiahuni
 * @create: 2019-01-16 14:26
 **/
public class OneValueCache {

    private volatile Cache cache = new OneValueCache.Cache(null);

    public void test() {

        if (true) {
            this.cache = new OneValueCache.Cache(new BigInteger("1"));
        }
    }


    private final static class Cache {

        private final BigInteger lastNum;

        public Cache(BigInteger lastNum) {
            this.lastNum = lastNum;
        }

        public BigInteger getLastNum() {
            return lastNum;
        }

        @Override
        public String toString() {
            return "Cache{" +
                    "lastNum=" + lastNum +
                    '}';
        }
    }
}
