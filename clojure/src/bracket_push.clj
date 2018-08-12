(ns bracket-push)

(defn opening? [c]
  (or (= c \( ) (= c \[) (= c \{)))

(defn closing? [c]
  (or (= c \) ) (= c \]) (= c \})))

(def pair-map {\) \( \] \[ \} \{})

(defn valid? [s] ;; <- arglist goes here
  (loop [brackets (map identity s) stack []]
    (if (empty? brackets)
      (empty? stack)
      (let [c (first brackets)]
        (cond
          (opening? c) (recur (rest brackets) (conj stack c))
          (closing? c) (if (= (pair-map c) (peek stack))
                         (recur (rest brackets) (pop stack))
                         false)
          :else (recur (rest brackets) stack))))
    )
  )
