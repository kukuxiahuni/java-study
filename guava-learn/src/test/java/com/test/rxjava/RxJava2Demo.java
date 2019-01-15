package com.test.rxjava;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @program: java-study
 * @description:
 * @author: kukuxiahuni
 * @create: 2019-01-14 19:31
 * 参考：https://www.jianshu.com/p/b39afa92807e
 **/
public class RxJava2Demo {

    private final static Logger LOGGER = LoggerFactory.getLogger(RxJava2Demo.class);


    @Test
    public void helloWorld() {

        Observable.just("Hello world").subscribe(System.out::println);
        Observable.just("Hello world ").subscribe(new Consumer<String>() {
            @Override
            public void accept(String s) throws Exception {
                System.out.println(s);
            }
        });

    }

    @Test
    public void testObserve() {
        Observable.just("Hello world").subscribe(
                new Observer<String>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        System.out.println("1");
                    }

                    @Override
                    public void onNext(String s) {
                        System.out.println(s);
                    }

                    @Override
                    public void onError(Throwable e) {
                        System.out.println(e.getMessage());
                    }

                    @Override
                    public void onComplete() {
                        System.out.println("done");
                    }
                }
        );
    }

    @Test
    public void testCreate() {

        Observable.create((ObservableEmitter<Integer> emitter) -> {
            emitter.onNext(1);
            emitter.onNext(2);
            emitter.onNext(3);
            emitter.onNext(4);
            emitter.onNext(5);
            emitter.onNext(6);
        }).map(integer -> {
            ++integer;
            return integer;
        }).subscribe(new Observer<Integer>() {

            private int integer = 0;
            private Disposable disposable;

            @Override
            public void onSubscribe(Disposable d) {
                this.disposable = d;
            }

            @Override
            public void onNext(Integer s) {
                LOGGER.info("emit num={}", s);
                integer++;

                if (integer == 4) {
                    this.disposable.dispose();
                    LOGGER.info("onNext截断, integer = {}", integer);
                }

                LOGGER.info("onNext, integer={}", integer);
            }

            @Override
            public void onError(Throwable e) {
                LOGGER.error("发生错误", e);
            }

            @Override
            public void onComplete() {

            }
        });
    }

    @Test
    public void createMap() {

        Observable.create((ObservableEmitter<Integer> emitter) -> {
            emitter.onNext(1);
            emitter.onNext(2);
            emitter.onNext(3);
            emitter.onNext(4);
            emitter.onNext(5);
            emitter.onNext(6);
        }).map(integer -> String.valueOf(integer))
                .subscribe(new Observer<String>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(String s) {
                        LOGGER.info(s);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });

    }

    /**
     * 按照顺序 两两结合
     */
    @Test
    public void createZip() {

        Observable<Integer> integerObservable = Observable.create((ObservableEmitter<Integer> emitter) -> {
            emitter.onNext(1);
            emitter.onNext(2);
            emitter.onNext(3);
            emitter.onNext(4);
            emitter.onNext(5);
            emitter.onNext(6);
        });

        Observable<String> stringObservable = Observable.create((ObservableEmitter<String> emitter) -> {
            emitter.onNext("A");
            emitter.onNext("B");
            emitter.onNext("C");
        });

        Observable.zip(integerObservable, stringObservable, (Integer integer, String string) -> {
            return integer + string;
        }).subscribe(new Observer<String>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(String s) {
                LOGGER.info(s);
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        });

    }

    @Test
    public void createConcat() {

        //1. 按照Observeable的顺序进行输出
        //2. 打平后数值不进行排序
        Observable.concat(Observable.just(1, 2, 3), Observable.just(1, 2, 3))
                .subscribe(integer -> {
                    LOGGER.info("concat result = {}", integer);
                });

    }


    /**
     * 说实在的，这个没看懂
     */
    @Test
    public void createFlatmap() {
        Observable.create((ObservableEmitter<Integer> emitter) -> {
            emitter.onNext(1);
            emitter.onNext(2);
            emitter.onNext(3);
            emitter.onNext(4);
            emitter.onNext(5);
            emitter.onNext(6);
        });
    }

    @Test
    public void testBuffer() {

        /**
         * count==skip时， skip会被忽略
         */
        Observable.just(1, 2, 3, 4, 5, 6,7,8).buffer(2, 3).subscribe(integers -> {
            LOGGER.info("------------------------");
            integers.forEach(
                    integer -> LOGGER.info("{}", integer)
            );
        });

    }


}
