package coffee.lambda

/*
 * Problem 5: Making a Century (based on Richard Bird's "Pearls of Functional Algorithm Design")
 * To make a century from a given sequence of digits means to insert "+" and "*"
 * between some of them, so that the value of the resulting arithmetic expression is 100.
 * E.g. from a sequence "1 2 3 4 5 6 7 8 9"
 * we can make the following century: 12 + 34 + 5 * 6 + 7 + 8 + 9.
 * Given a sequence of digits, compute the number of ways to make a century with them.
 */

object Ex05CenturySolution {
  type Digit = Int
  type Factor = List[Digit]
  type Term = List[Factor]
  type Expression = List[Term]

  def valFactor(x: Factor): Int = x.foldLeft(0)((acc, digit) => 10 * acc + digit)
  def valTerm(x: Term): Int = x.map(valFactor).product
  def valExpression(x: Expression) = x.map(valTerm).sum

  def prependDigit(d: Digit)(exp: Expression): List[Expression] = exp match {
    case (xs :: xss) :: xsss => List(((d :: xs) :: xss) :: xsss,
                                     (List(d) :: xs :: xss) :: xsss,
                                     List(List(d)) :: (xs :: xss) :: xsss)
  }

  def extend(d: Digit, exps: List[Expression]): List[Expression] = exps match {
    case Nil => List(List(List(List(d))))
    case _ => exps.flatMap(prependDigit(d))
  }

  def allExpressions(digs: List[Digit]): List[Expression] = digs.foldRight(List[Expression]())(extend)

  def goodValue(v: Int): Boolean = v == 100

  def allSolutions(digs: List[Digit]): List[Expression] = allExpressions(digs)
                                                         .filter(valExpression _ andThen goodValue)

  def countSolutions(digs: List[Digit]): Int = allSolutions(digs).size

}
