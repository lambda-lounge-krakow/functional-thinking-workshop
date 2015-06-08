package coffee.lambda

/*
 * Problem 5: Making a Century (based on Richard Bird's "Pearls of Functional Algorithm Design")
 * To make a century from a given sequence of digits means to insert "+" and "*"
 * between some of them, so that the value of the resulting arithmetic expression is 100.
 * E.g. from a sequence "1 2 3 4 5 6 7 8 9"
 * we can make the following century: 12 + 34 + 5 * 6 + 7 + 8 + 9.
 * Given a sequence of digits, compute the number of ways to make a century with them.
 */

object Ex05CenturyStep02 {
  type Digit = Int
  type Expression = Unit

  def allSolutions(digs: List[Digit]): List[Expression] = ???

  def countSolutions(digs: List[Digit]): Int = allSolutions(digs).size

}