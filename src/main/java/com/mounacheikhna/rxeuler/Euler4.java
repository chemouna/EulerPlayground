package com.mounacheikhna.rxeuler;

import rx.Observable;

/**
 * Created by cheikhnamouna on 11/10/15.
 *
 * Find the largest palindrome made from the product of two 3-digit numbers.
 */
public class Euler4 {
    public static void main(String... args) {
        //899 is the count to get to 999 (= 100 + 899) 
        Observable.range(100, 899).flatMap(a -> Observable.range(a, 999 - a).map(b -> a * b))
                .filter(r -> {
                    String newStr = new StringBuilder(String.valueOf(r)).reverse().toString();
                    return String.valueOf(r).equals(newStr);
                })
                .reduce((i1, i2) -> i1 < i2 ? i2 : i1)
                .subscribe(r -> {
                    System.out.println("Result : " + r);
                });
    }

}
