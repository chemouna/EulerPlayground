package com.mounacheikhna.rxeuler;

import rx.Observable;

/**
 * Created by cheikhnamouna on 12/31/15.
 *
 * By listing the first six prime numbers: 2, 3, 5, 7, 11, and 13, we can see that the 6th prime
 * is 13.
 * What is the 10 001st prime number?
 */
public class Euler7 {

  public static void main(String... args) {
    Observable.range(0, Integer.MAX_VALUE)
        .filter(Euler7::isPrime)
        .take(10001)
        .skip(10000)
        .subscribe(System.out::println);
  }

  private static boolean isPrime(int num) {
    if (num < 2) return false;
    if (num == 2) return true;
    if (num % 2 == 0) return false;
    for (int i = 3, p = (int) Math.sqrt(num); i <= p; i++)
      if (num % i == 0) return false;
    return true;
  }

}