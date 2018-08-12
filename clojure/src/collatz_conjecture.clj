(ns collatz-conjecture)

(defn collatz [num] ;; <- arglist goes here
  (when (<= num 0) (throw (IllegalArgumentException. "number is not positive")))
  (loop [n num count 0]
    (cond (= 1 n) count
          (even? n) (recur (/ n 2) (inc count))
          (odd? n) (recur (+ 1 (* n 3)) (inc count)))))


(collatz -1)


