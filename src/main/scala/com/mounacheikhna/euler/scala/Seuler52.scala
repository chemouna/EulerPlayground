package com.mounacheikhna.euler.scala

/**
  Permuted multiples :
  It can be seen that the number, 125874, and its double, 251748, contain exactly the
  same digits, but in a different order.
  Find the smallest positive integer, x, such that 2x, 3x, 4x, 5x, and 6x,
  contain the same digits.
 **/

object Seuler52 {

  def toset(x: Int) = x.toString.toSet

  def digits(x: Int) = {
    val x1 = toset(x)
    val x2 = toset(2 * x)
    val x3 = toset(3 * x)
    val x4 = toset(4 * x)
    val x5 = toset(5 * x)
    val x6 = toset(6 * x)
    val ls = List(x2, x3, x4, x5, x6) forall (_ == x1)
    ls
  }

  def main (args: Array[String]){
    var n = 11
    var end = false
    while (!end) {
      if (digits(n)) {
        println("result: " + n, 2 * n, 3 * n, 4 * n, 5 * n, 6 * n);
        end = true
      }
      n += 1
      if (n % 1000 == 0) println(n)
    }
  }

}
