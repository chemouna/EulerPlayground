package com.mounacheikhna.kteuler

/**
 * Created by cheikhnamouna on 1/9/16.
 */


inline fun Any.toCharList() = toString().toArrayList()
inline fun Any.isPalindrome = toCharList() == toCharList().reversed()