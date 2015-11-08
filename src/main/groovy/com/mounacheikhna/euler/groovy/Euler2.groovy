package com.mounacheikhna.euler.groovy

import rx.Observable;

/**
 * Generate the Fibonacci Sequence
 */

//Solution #1
def fibonacci1 = Observable.from(0).repeat().scan([0,1], { a,b -> [a[1], a[0]+a[1]] }).map({it[1]});
fibonacci1.take(10).subscribe({ println(it); })
