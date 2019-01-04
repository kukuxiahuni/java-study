package com.test.hystrix;

import org.junit.Test;
import rx.Observable;


public class HelloWorldHystrixCommandTest {


    @Test
    public void test() {
        String result = new HelloWorldHystrixCommand("HLX").execute();
        Observable<String> observable = new HelloWorldHystrixCommand("hlx").observe();
        System.out.println(result);
    }

}