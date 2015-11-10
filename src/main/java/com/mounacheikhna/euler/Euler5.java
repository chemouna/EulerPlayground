package com.mounacheikhna.euler;

import rx.Observable;
import rx.functions.Action1;
import rx.functions.Func1;

/**
 * Created by cheikhnamouna on 11/10/15.
 *
 * What is the smallest number divisible by each of the numbers 1 to 20?
 */
public class Euler5 {

    //Attempt at Euler 5 not working yet
    public static void main(String... args) {
        Observable<Integer> range = Observable.range(1, 19);
        Observable.sequenceEqual(
                Observable.range(1, Integer.MAX_VALUE).flatMap(a -> range.map(b -> a % b))
                , Observable.just(0).repeat(20))

    }

}
