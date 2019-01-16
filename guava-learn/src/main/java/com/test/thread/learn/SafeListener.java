package com.test.thread.learn;

import org.apache.commons.configuration.event.EventSource;

import java.util.EventListener;

/**
 * @program: java-study
 * @description:
 * @author: kukuxiahuni
 * @create: 2019-01-16 13:48
 **/
public class SafeListener {

    private final EventListener eventListener;

    private SafeListener() {
        this.eventListener = new EventListener() {
            public void onEvent() {
                System.out.println("do something");
            }
        };
    }

    public final static SafeListener newInstance(EventSource eventSource) {

        SafeListener safeListener = new SafeListener();
        return safeListener;
    }
}
