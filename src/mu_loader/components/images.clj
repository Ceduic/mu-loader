(ns mu-loader.components.images)

(def image-count (atom 0))

(defn save-image [file]
  )

(defn get-images [parameters]
  ;; Return an array of images based on query parameters
  [{:id -1
    :description "Placeholder image"
    :uploader "Nick"
    :img-url "/data/images/test.jpg"
    :date "11/01/2016"
    :rating -1}])

(defn get-image [id]
  ;; Return info for specific image
  {:id id
   :description "Placeholder image"
   :uploader "Nick"
   :img-url "/data/images/test.jpg"
   :date "11/01/2016"
   :rating -1})
