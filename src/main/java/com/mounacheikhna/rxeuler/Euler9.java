package com.mounacheikhna.rxeuler;

import java.util.ArrayList;
import java.util.List;
import rx.Observable;
import rx.functions.Func3;

/**
 * Created by cheikhnamouna on 1/2/16.
 *
 * A Pythagorean triplet is a set of three natural numbers, a < b < c, for which,
 * a2 + b2 = c2
 * For example, 32 + 42 = 9 + 16 = 25 = 52.
 *
 * There exists exactly one Pythagorean triplet for which a + b + c = 1000.
 * Find the product abc.
 *
 */
public class Euler9 {

  public static void main(String... args) {
    withRx();
    nonRxWay();
  }

  private static void withRx() {
    Observable<Integer> rangeA = Observable.range(1, 500);
    Observable<Integer> rangeB = rangeA.flatMap(a -> Observable.range(a, 500));
    Observable<Integer> rangeC = rangeB.flatMap(b -> Observable.range(b, 500));

    Observable.zip(rangeA, rangeB, rangeC,
        (Func3<Integer, Integer, Integer, List<Integer>>) (a, b, c) -> {
          ArrayList<Integer> integers = new ArrayList<>();
          integers.add(a);
          integers.add(b);
          integers.add(c);
          return integers;
        })
    .filter(integers -> {
      int a = integers.get(0);
      int b = integers.get(1);
      int c = integers.get(2);
      return (((a * a) + (b * b) == (c * c)) && (a + b + c == 1000));
    })
    .map(integers -> integers.get(0) * integers.get(1) * integers.get(2))
    .subscribe(result -> {
      System.out.println(" Result : "+ result);
    });

  }

  private static void nonRxWay() {
    int a, b, c;
    for (a = 1; a <= 500; a++) {
      for (b = a; b <= 500; b++) {
        for (c = b; c <= 500; c++) {
          if (((a * a) + (b * b) == (c * c)) && (a + b + c == 1000)) {
            System.out.println("Non Rx: "+ (a * b * c));
            break;
          }
        }
      }
    }
  }
}
