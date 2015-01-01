(ns random-list.core
  (:gen-class))

(defn get_min [args] (. Integer parseInt (nth args 0)))
(defn get_max [args] (. Integer parseInt (nth args 1)))
(defn get_num_elements [args] (. Integer parseInt (nth args 2)))
(defn rand_range [minimum maximum] (+ minimum (rand-int (- (+ 1 maximum) minimum))))

(defn add_unique [nums minimum maximum] (vec (set (conj nums (rand_range minimum maximum)))))
(defn gen_nums [nums minimum maximum num_elements] (if (>= (count nums) num_elements) nums (gen_nums (add_unique nums minimum maximum) minimum maximum num_elements)))

(defn -main
  "Generate a random list of unique integers."
  [& args]
  (println (sort (gen_nums [] (get_min args) (get_max args) (get_num_elements args)))))
