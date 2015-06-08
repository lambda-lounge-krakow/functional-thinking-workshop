import coffee.lambda.Ex05Century._
import org.scalatest._

class Ex05CenturySpec extends FlatSpec with Matchers {
  def testCase(digs: List[Digit], exp: Int) {
    countSolutions(digs) should be(exp)
  }

  "countSolutions" should "give correct answers" in {
    testCase(1 :: 2 :: 3 :: 4 :: 5 :: 6 :: 7 :: 8 :: 9 :: Nil, 7)
    testCase(1 :: Nil, 0)
    testCase(1 :: 1 :: 9 :: 9 :: Nil, 2)
    testCase(1 :: 1 :: 8 :: 9 :: Nil, 1)
  }
}
