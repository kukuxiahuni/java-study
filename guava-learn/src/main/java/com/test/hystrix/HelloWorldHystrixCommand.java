package com.test.hystrix;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import com.netflix.hystrix.HystrixThreadPoolKey;

/**
 * @program: java-study
 * @description: 测试
 * @author: kukuxiahuni
 * @create: 2019-01-02 16:12
 **/
public class HelloWorldHystrixCommand extends HystrixCommand<String> {

    private final String name;

    public HelloWorldHystrixCommand(String name) {
        super(HystrixCommandGroupKey.Factory.asKey("ExampleGroup"));
        this.name = name;
    }


    @Override
    protected String run() throws Exception {
        return "哈哈";
    }
}
