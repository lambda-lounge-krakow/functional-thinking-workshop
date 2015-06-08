package coffee.lambda

/* Problem 2: Tail-Recursion and Coinduction.
 * Implement two functions for computing the Fibonacci sequence.
 * First function should be tail-recursive.
 * Second should make use of infinite streams.
 */

object Ex02Fibonacci {
  def tailFibonacci(n: Int): BigInt = ???
  val fibs: Stream[BigInt] = ???
  def streamFibonacci(n: Int): BigInt = fibs(n)
}
