package coffee.lambda


/* Problem 3: Folds.
 * Implement three versions of fold function.
 * a) foldLeft  - tail recursive function applying the function in the left-to-right order.
 * b) foldRight - non-tail recursive, applying right-to-left.
 * c) folds     - using list-manipulation techniques generate a stream of all partial results
 *                of folding in the left-to-right order.
 */

object Ex03Folds {
  def foldLeft[A, B](fun: (B, A) => B, acc: B, list: List[A]): B = ???

  def foldRight[A, B](fun: (A, B) => B, acc: B, list: List[A]): B = ???

  def folds[A, B](fun: (A, B) => B, acc: B, list: List[A]): Stream[B] = ???
}
