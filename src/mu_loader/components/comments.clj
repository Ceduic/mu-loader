(ns mu-loader.components.comments
  (:require [korma.core :as korma]
            [mu-loader.components.db :as dbd]))

(defn get-comments [id]
  ;; Returns comments for image
  [{:content "Wow, nice pic"
    :nick "ProC0mmenter"
    :date "01/11/2016"
    :rating 13}
   {:content "I've seen better"
    :nick "Nick"
    :date "01/11/2016"
    :rating -1}])
