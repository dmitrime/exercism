(ns protein-translation)

(defn translate-codon [codon] ;; <- arglist goes here
      (cond
        (contains? #{"AUG"} codon) "Methionine"
        (contains? #{"UUU" "UUC"} codon) "Phenylalanine"
        (contains? #{"UUA" "UUG"} codon) "Leucine"
        (contains? #{"UCU" "UCC" "UCA" "UCG"} codon) "Serine"
        (contains? #{"UAU" "UAC"} codon) "Tyrosine"
        (contains? #{"UGU" "UGC"} codon) "Cysteine"
        (contains? #{"UGG"} codon) "Tryptophan"
        (contains? #{"UAA" "UAG" "UGA"} codon) "STOP"))

(defn translate-rna [s] ;; <- arglist goes here
  (->> s
    (partition 3)
    (map (partial apply str))
    (map translate-codon)
    (take-while #(not= % "STOP"))))
