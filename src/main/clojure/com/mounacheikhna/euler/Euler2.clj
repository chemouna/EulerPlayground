

(ns com.mounacheikhna.euler)

 (defn fibs
   ([] (fibs 1 2))
   ([a b] (lazy-seq (cons a (fibs b (+ a b))))))

  (defn solution []
    (println (reduce + (filter #(= 0 (mod % 2)) (take-while (partial > 4e6) (fibs))))))
  (solution)
