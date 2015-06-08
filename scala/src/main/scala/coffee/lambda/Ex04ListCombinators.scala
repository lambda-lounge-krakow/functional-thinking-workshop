package coffee.lambda

/* Using only the library foldLeft and foldRight methods (no primitive recursion, iteration etc.)
 * implement the following list combinators:
 * a) reverse
 * b) map
 * c) filter
 * d) append
 * e) concat
 */

object Ex04ListCombinators {
  def reverse[T](list: List[T]): List[T] = ???

  def map[T, R](list: List[T], fun: T => R): List[R] = ???

  def filter[T](list: List[T], pred: T => Boolean): List[T] = ???

  def append[T](a: List[T], b: List[T]): List[T] = ???

  def concat[T](a: List[List[T]]): List[T] = ???
}
