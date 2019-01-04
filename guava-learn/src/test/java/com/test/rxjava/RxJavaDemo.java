package com.test.rxjava;

import org.junit.Test;
import rx.Observable;
import rx.Subscriber;

/**
 * @program: java-study
 * @description:
 * @author: kukuxiahuni
 * @create: 2019-01-02 18:56
 **/
public class RxJavaDemo {

    @Test
    public void test() {

        Observable<String> observable = Observable.create(new Observable.OnSubscribe<String>() {
            public void call(Subscriber<? super String> subscriber) {
                subscriber.onNext("hello huang");
                subscriber.onNext("牛逼");
                subscriber.onCompleted();
            }
        });

        //创建订阅者
        Subscriber<String> subscriber = new Subscriber<String>() {
            public void onCompleted() {

            }

            public void onError(Throwable throwable) {

            }

            public void onNext(String s) {
                System.out.println("subscribe: " + s);
            }
        };

        //订阅
        observable.subscribe(subscriber);

    }
}
