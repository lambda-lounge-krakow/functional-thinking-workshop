import Test.HUnit

{-
 - Problem 5: Making a Century (based on Richard Bird's "Pearls of Functional Algorithm Design")
 - To make a century from a given sequence of digits means to insert "+" and "*"
 - between some of them, so that the value of the resulting arithmetic expression is 100.
 - e.g. from a sequence "1 2 3 4 5 6 7 8 9"
 - we can make the following century: 12 + 34 + 5 * 6 + 7 + 8 + 9.
 - Given a sequence of digits, compute the number of ways to make a century with them.
 -}

type Digit = Integer
type Expression = ()

valExpr :: Expression -> Integer
valExpr = undefined

allExpressions :: [Digit] -> [Expression]
allExpressions = undefined

goodValue :: Integer -> Bool
goodValue = undefined

allSolutions :: [Digit] -> [Expression]
allSolutions = filter (goodValue . valExpr) . allExpressions

countSolutions :: [Digit] -> Int
countSolutions = length . allSolutions

--------------------------------------------------------------------------------
-----------------------------------TEST CASES-----------------------------------
--------------------------------------------------------------------------------

testExample digits expected = TestCase $ assertEqual "the answer is correct" expected (countSolutions digits)

main = runTestTT $ TestList [ testExample [1, 2, 3, 4, 5, 6, 7, 8, 9] 7
                            , testExample [1] 0
                            , testExample [1, 1, 9, 9] 2
                            , testExample [1, 1, 8, 9] 1 ]
