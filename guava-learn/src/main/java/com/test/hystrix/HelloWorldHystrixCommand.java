package com.test.hystrix;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import com.netflix.hystrix.HystrixThreadPoolKey;
import rx.Observable;
import rx.Subscriber;


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
        getExecutionException();// 获取执行异常
        return "哈哈";
    }

    /**
     * 另一种写法
     *
     * @return
     */
    protected Observable<String> anotherRun() {
        return Observable.create(new Observable.OnSubscribe<String>() {
            public void call(Subscriber<? super String> subscriber) {

                if (!subscriber.isUnsubscribed()) {
                    subscriber.onNext("a");
                    subscriber.onCompleted();
                }
            }
        });
    }

    /**
     * 降级方案
     * @return
     */
    @Override
    protected String getFallback() {
        return "哈哈fallback";
    }
}
