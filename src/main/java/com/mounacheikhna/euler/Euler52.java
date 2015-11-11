package com.mounacheikhna.euler;

import java.util.Arrays;
import rx.Observable;
import rx.functions.Func1;

/**
 *
 * Permuted multiples :
 * It can be seen that the number, 125874, and its double, 251748, contain exactly the
 * same digits, but in a different order.
 * Find the smallest positive integer, x, such that 2x, 3x, 4x, 5x, and 6x,
 * contain the same digits.
 *
 * Created by cheikhnamouna on 11/11/15.
 */
public class Euler52 {

  public static void main(String... args) {
    Observable<Integer> start = Observable.range(1, Integer.MAX_VALUE);
    Observable<String> startStr = start.map(String::valueOf);
    Observable<String> obs2x = start.map(a -> a * 2).compose(toStringSeq());
    Observable<String> obs3x = start.map(a -> a * 3).compose(toStringSeq());
    Observable<String> obs4x = start.map(a -> a * 4).compose(toStringSeq());
    Observable<String> obs5x = start.map(a -> a * 5).compose(toStringSeq());
    Observable<String> obs6x = start.map(a -> a * 6).compose(toStringSeq());

    Observable.zip(startStr, obs2x, obs3x, obs4x, obs5x, obs6x,
        (s, s2, s3, s4, s5, s6) -> {
          if(sameChars(s, s2) && sameChars(s, s3) && sameChars(s, s4) && sameChars(s, s5) && sameChars(s, s6)) {
            return s;
          }
          return null;
        })
        .takeFirst(o -> o != null)
        .subscribe(s -> {
          System.out.println(" res : "+ s);
        });
  }

  private static boolean sameChars(String firstStr, String secondStr) {
    char[] first = firstStr.toCharArray();
    char[] second = secondStr.toCharArray();
    Arrays.sort(first);
    Arrays.sort(second);
    return Arrays.equals(first, second);
  }

  public static <T> Observable.Transformer<T, String> toStringSeq() {
    return o -> o.map(t -> String.valueOf(t));
  }

}
