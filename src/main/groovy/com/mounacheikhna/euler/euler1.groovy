package com.mounacheikhna.euler

import rx.Observable;

/**
 If we list all the natural numbers below 10 that are multiples of
 3 or 5, we get 3, 5, 6 and 9. The sum of these multiples is 23.
 Find the sum of all the multiples of 3 or 5 below 1000.
 **/

def solution1 = { Observable.range(1,999).filter({ !((it % 3) && (it % 5)) }) };

def threes = Observable.range(1,999).map({it*3}).takeWhile({it<1000});
def fives = Observable.range(1,999).map({it*5}).takeWhile({it<1000});
def solution2 = { Observable.merge(threes, fives).distinct() };

solution1().toBlocking().subscribe({ println(it)})

solution2().toBlocking().subscribe({ println(it)})
