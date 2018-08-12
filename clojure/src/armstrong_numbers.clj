(ns armstrong-numbers)

 (defn exp [x n]
  (loop [acc 1 n n]
    (if (zero? n) acc
        (recur (* x acc) (dec n))))) 

(defn armstrong? [n]
  (let [xs (str n)
        l (count xs)
        nums (map #(- (int %) 48) xs)
        sum (reduce + (map #(exp % l) nums))
        ]
    (= n sum)
    )
  )
