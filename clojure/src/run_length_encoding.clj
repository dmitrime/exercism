(ns run-length-encoding)

(defn run-length-encode
  "encodes a string with run-length-encoding"
  [plain-text]
  (->> plain-text
       (partition-by identity)
       (map #(vector (if (= 1 (count %)) (first %) [(count %) (first %)])))
       flatten
       (apply str)))

(defn run-length-decode
  "decodes a run-length-encoded string"
  [cipher-text]
  (->> cipher-text
       (re-seq #"(\d*)([a-zA-Z\s])")
       (map rest)
       (map #(vector (if (empty? (first %)) 1 (Integer/parseInt (first %))) (second %)))
       (map #(repeat (first %) (second %)))
       flatten
       (apply str)))
