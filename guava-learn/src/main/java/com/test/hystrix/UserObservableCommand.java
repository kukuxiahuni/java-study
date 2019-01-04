package com.test.hystrix;

import com.netflix.hystrix.HystrixObservableCommand;
import rx.Observable;
import rx.Subscriber;

/**
 * @program: java-study
 * @description:
 * @author: kukuxiahuni
 * @create: 2019-01-04 18:38
 **/
public class UserObservableCommand extends HystrixObservableCommand<String> {

    private Long id;

    public UserObservableCommand(Setter setter, long id) {
        super(setter);
        this.id = id;
    }


    @Override
    protected Observable<String> construct() {

        return Observable.create(new Observable.OnSubscribe<String>() {
            public void call(Subscriber<? super String> subscriber) {

                if (!subscriber.isUnsubscribed()) {
                    subscriber.onNext("hha");
                    subscriber.onNext("hh");
                    subscriber.onCompleted();
                }

            }
        });
    }
}
