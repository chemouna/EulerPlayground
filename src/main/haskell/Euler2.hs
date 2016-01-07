

euler2 = sum [ x | x <- takeWhile (<= 1000000) fibonacci : even x]
  where
    fibonacci = 1 : 1 : zipWith (+) fibonacci (tail fibonacci)