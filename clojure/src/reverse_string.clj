(ns reverse-string)

(defn reverse-string [s]
  (if (empty? s)
    ""
    (str (reverse-string (rest s)) (first s)))
)
