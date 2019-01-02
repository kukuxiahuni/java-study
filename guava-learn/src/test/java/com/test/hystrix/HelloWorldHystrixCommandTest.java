package com.test.hystrix;

import static org.junit.Assert.*;

public class HelloWorldHystrixCommandTest {


    public void test() {
        String result = new HelloWorldHystrixCommand("HLX").execute();
        System.out.println(result);
    }

}