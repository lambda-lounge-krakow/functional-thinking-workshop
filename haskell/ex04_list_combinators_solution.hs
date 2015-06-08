import Test.HUnit

{-
 - Problem 4: List Combinators.
 - Using only foldl and foldr (no recursion etc.) implement the following list combinators:
 - a) reverse'
 - b) map'
 - c) filter'
 - d) concat'
 - Bonus points for using currying and point-free notation :).
 -}

reverse' :: [a] -> [a]
reverse' = foldl (flip (:)) []

map' :: (a -> b) -> [a] -> [b]
map' f = foldr (\el acc -> (f el) : acc) []

filter' :: (a -> Bool) -> [a] -> [a]
filter' f = foldr (\el acc -> if f el then el : acc else acc) []

concat' :: [[a]] -> [a]
concat' = foldr (flip $ foldr (:)) []

--------------------------------------------------------------------------------
-----------------------------------TEST CASES-----------------------------------
--------------------------------------------------------------------------------

testReverse = TestCase $ assertEqual "revese' reverses" [3, 2, 1] (reverse' [1, 2, 3])

testMap = TestCase $ assertEqual "map' maps" [2, 3, 4] (map' (+ 1) [1, 2, 3])

testFilter = TestCase $ assertEqual "filter' filters" [2, 4] (filter' even [1, 2, 3, 4])

testConcat = TestCase $ assertEqual "concat' concats" [1, 2, 3, 4, 5] (concat' [[1, 2], [3, 4], [5]])

main = runTestTT $ TestList [ testReverse
                            , testMap
                            , testFilter
                            , testConcat ]
