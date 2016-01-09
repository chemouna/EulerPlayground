

(ns com.mounacheikhna.euler)

 (defn fibs
   ([] (fibs 1 2))
   ([a b] (lazy-seq (cons a (fibs b (+ a b))))))

  (defn solution1 []
    (println (reduce + (filter #(= 0 (mod % 2)) (take-while (partial > 4e6) (fibs))))))
  (solution1)

  (defn solution2 [limit]
    (println (reduce + (take-while (partial >= limit)
                                   (filter even? (fibs))))))
  (solution2 4000000)


;learning related clojure to solve this
;cons
;(println (cons 1 '(9 5 6)))
;(println (cons [1 2] [4 5 6]))

;lazy-seq
;(defn positive_nbrs
;  ([] (positive_nbrs 1))
;  ([n] (lazy-seq (cons n (positive_nbrs (inc n))))))
;(println (take 5 (positive_nbrs)))

;reduce
;(println (reduce + [1 2 3]))
;(println (reduce + 1 []))
;(println (reduce conj #{} [:a :b :c]))

;take-while
;calculate sum of nbers under 1000
;(println (reduce + (take-while (partial > 1000) (iterate inc 0))))
;show negative nbrs
;(println (take-while neg? [-2 -1 0 1 2 3]))