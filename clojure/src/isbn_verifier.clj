(ns isbn-verifier)

(defn to-digit [c] (Character/digit c 10))
(defn digit? [n] (<= 0 n 9))

(defn isbn? [isbn] ;; <- arglist goes here
  (let [cleaned (vec (filter #(not= \- %) isbn))
        length (count cleaned)
        last-char (peek cleaned)
        isbn-prefix (pop cleaned)
        only-digits (every? (fn [x] (digit? (to-digit x))) isbn-prefix)
        is-last-valid (or (= \X last-char) (digit? (to-digit last-char)))
        last-num (if (= \X last-char) 10 (to-digit last-char))
        digits (map to-digit isbn-prefix)
        multiples9 (reduce + (map * digits (range 10 1 -1)))]
    (and (= 10 length)
         only-digits
         is-last-valid
         (= 0 (mod (+ last-num multiples9) 11)))
    ))
