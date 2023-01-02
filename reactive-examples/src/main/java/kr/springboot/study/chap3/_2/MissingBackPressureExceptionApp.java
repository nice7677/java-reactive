package kr.springboot.study.chap3._2;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.schedulers.Schedulers;

import java.util.concurrent.TimeUnit;

public class MissingBackPressureExceptionApp {

    public static void main(String[] args) {

        Flowable.interval(1L, TimeUnit.MILLISECONDS)
                .doOnNext(data -> {
                    System.out.println(data);
                })
                .observeOn(Schedulers.computation())
                .subscribe(data -> {
                    System.out.println("소비자 처리 대기중 ..");
                    TimeUnit.SECONDS.sleep(1);
                },
                        error -> {
                            System.out.println(error);
                        });

    }

}
