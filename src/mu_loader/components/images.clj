(ns mu-loader.components.images)

(defn get-images [& parameters]
  ;; Return an array of images based on query parameters
  [{:id -1
    :description "Placeholder image"
    :img-url "/data/images/test.jpg"
    :date "11/01/2016"
    :rank -1}])

(defn get-image [id]
  ;; Return info for specific image
  {:id id
   :description "Placeholder image"
   :img-url "/data/images/test.jpg"
   :date "11/01/2016"
   :rank -1})