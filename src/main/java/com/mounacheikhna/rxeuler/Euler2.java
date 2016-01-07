package com.mounacheikhna.rxeuler;

import rx.Observable;
import rx.Subscriber;

/**
 * Created by cheikhnamouna on 11/8/15.
 * Generate the Fibonacci Sequence
 */
public class Euler2 {
    public static void main(String... args) {
        System.out.println(" Via Observable.create : ");
        fibViaCreate.take(13).forEach(System.out::println);

        System.out.println(" Via scan : ");
        fibViaScan.take(13).forEach(System.out::println);
    }

    static Observable<Integer> fibViaScan = Observable.just(new Integer[]{0, 1}).repeat()
            .scan(new Integer[]{0, 1}, (a, b) -> new Integer[]{a[1], a[0] + a[1]})
            .map(integers -> integers[1])
            .startWith(0);

    static Observable<Integer> fibViaCreate = Observable.create((Subscriber<? super Integer> s) -> {
        int f1 = 0, f2 = 1, fn;
        s.onNext(0);
        s.onNext(1);
        while (!s.isUnsubscribed()) {
            fn = f1 + f2;
            f1 = f2;
            f2 = fn;
            s.onNext(fn);
        }
    });
}