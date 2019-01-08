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

    @Test
    public void justTest() {

        /**
         * 最多10个元素
         */
        Observable.just(1, 2, 3).subscribe(new Subscriber<Integer>() {
            public void onCompleted() {

            }

            public void onError(Throwable e) {

            }

            public void onNext(Integer integer) {
                System.out.println(integer);
            }
        });

    }

    @Test
    public void testArray() {

        Integer[] array = {1, 2, 3, 45, 6, 7, 7, 9, 10, 11, 12};

        Observable.from(array).subscribe(new Subscriber<Integer>() {
            public void onCompleted() {
                System.out.println("done");
            }

            public void onError(Throwable e) {

            }

            public void onNext(Integer integer) {
                System.out.println(integer);
            }

        });
    }
}
