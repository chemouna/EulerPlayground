package com.mounacheikhna.euler.groovy

import rx.Observable;

def buffer = Observable.from("t1", "t2", "t3", "t4", "t5").buffer(2, 1);
buffer.subscribe({ println(it); })
