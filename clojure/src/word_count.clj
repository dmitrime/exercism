(ns word-count
  (:require [clojure.string :as string]))

(defn word-count-version1 [s] ;; <- arglist goes here
  (reduce (fn [m k] (assoc m k (inc (get m k 0))))
          {}
          (string/split (string/lower-case s) #"\W+")))

(defn word-count [s]
  (frequencies (string/split (string/lower-case s) #"\W+")))
