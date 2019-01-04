package com.test.hystrix;

import com.netflix.hystrix.*;
import com.netflix.hystrix.strategy.concurrency.HystrixConcurrencyStrategyDefault;
import com.sun.xml.internal.bind.v2.model.core.ID;
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
     *
     * @return
     */
    @Override
    protected String getFallback() {
        return "哈哈fallback";
    }

    @Override
    protected String getCacheKey() {
        return super.getCacheKey();
    }

    public final void flushCache() {
        HystrixRequestCache.getInstance(HystrixCommandKey.Factory.asKey("ke"),
                HystrixConcurrencyStrategyDefault.getInstance()).clear(String.valueOf(name));

    }
}
