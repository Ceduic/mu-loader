(ns mu-loader.components.images
  (:require [clojure.java.io :as io]))

(def image-count (atom 0))

;; Save image to directory
(defn save-image [file]
  (if (not (nil? file))
    (let [file-name (file :filename)
          size (file :size)
          file-type (file :content-type)
          temp-file (file :tempfile)]
      (cond
        (not (or (= file-type "image/jpeg") (= file-type "image/png"))) false
        (> size 4096000) false
       :else
       (let [image-file (io/file "resources" "public" "data" "images" file-name)]
         (try
           (do
             (io/make-parents image-file)
             (io/copy temp-file image-file)
             true)
           (catch java.io.IOException e false)))))
    false)
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
