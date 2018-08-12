(ns bob
  (:require [clojure.string :as s]))

(defn response-for [s]
  (cond
    (s/includes? s "?") ("Sure.")
    (= (s/upper-case s) s) ("Whoa, chill out!")
    (empty? (s/trim s)) ("Fine. Be that way!")
    :else "Whatever."
    )
  )
