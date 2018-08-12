(ns reverse-string
  (require [clojure.string :as s])
  )

(defn responds-to-something [s]
  (cond
    (s/blank? (s/trim s)) "Fine. Be that way!"
    (s/ends-with? s "?") "Sure."
    (= (s/upper-case s) s) "Whoa, chill out!"
    :else "Whatever."
    )
  )

