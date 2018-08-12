(ns rna-transcription)


(defn rna [nuc]
  (cond (= nuc \A) \U
        (= nuc \C) \G
        (= nuc \T) \A
        (= nuc \G) \C
        :else (throw (AssertionError. ""))
        )
  )

(defn to-rna [s] (apply str (map rna s)))

