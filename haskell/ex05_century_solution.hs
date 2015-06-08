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
type Factor = [Digit]
type Term = [Factor]
type Expression = [Term]

valFactor :: Factor -> Integer
valFactor = foldl (\acc digit -> 10 * acc + digit) 0

valTerm :: Term -> Integer
valTerm = product . map valFactor

valExpr :: Expression -> Integer
valExpr = sum . map valTerm

extend :: Digit -> [Expression] -> [Expression]
extend x [] = [[[[x]]]]
extend x es = concatMap (prependDigit x) es

prependDigit :: Digit -> Expression -> [Expression]
prependDigit x ((xs : xss) : xsss) = [((x : xs) : xss) : xsss,
                                      ([x] : xs :xss) : xsss,
                                      [[x]] : (xs : xss) : xsss]

allExpressions :: [Digit] -> [Expression]
allExpressions = foldr extend []

goodValue :: Integer -> Bool
goodValue = (== 100)

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
