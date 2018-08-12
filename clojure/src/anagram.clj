(ns anagram)

(defn anagrams-for [word prospect-list] ;; <- arglist goes here
  (let [lower-word (clojure.string/lower-case word)
        sorted-word (sort lower-word)
        filtered-list (filter #(not= lower-word %) prospect-list)]
    (filter
      #(= sorted-word (sort (clojure.string/lower-case %)))
      filtered-list))
)
