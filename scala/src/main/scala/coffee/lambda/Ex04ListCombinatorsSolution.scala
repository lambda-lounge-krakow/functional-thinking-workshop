package coffee.lambda

/* Using only the library foldLeft and foldRight methods (no primitive recursion, iteration etc.)
 * implement the following list combinators:
 * a) reverse
 * b) map
 * c) filter
 * d) append
 * e) concat
 */

object Ex04ListCombinatorsSolution {
  def reverse[T](list: List[T]): List[T] = list.foldLeft(List[T]())((list, elt) => elt :: list)

  def map[T, R](list: List[T], fun: T => R): List[R] = list.foldRight(List[R]())((elt, acc) => fun(elt) :: acc)

  def filter[T](list: List[T], pred: T => Boolean): List[T] = list.foldRight(List[T]())(
    (elt, acc) => if (pred(elt)) elt :: acc else acc
  )

  def append[T](a: List[T], b: List[T]): List[T] = a.foldRight(b)(_ :: _)

  def concat[T](a: List[List[T]]): List[T] = a.foldRight(List[T]())(append)
}
