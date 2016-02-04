;;; Define database and other shared settings

(ns mu-loader.components.db
  (:require [korma.db :refer :all]
            [korma.core :as korma]))

(def db {:classname   "org.h2.Driver"
         :subprotocol "h2"
         :subname     "resources/db/mu-loader"})

(defdb database db)

(declare image user user-comment)

(korma/defentity image
  (korma/entity-fields :img-url :rating :date :user)

  ;; Maps image.id = user-comment.image_id
  (korma/has-many user-comment))

(korma/defentity user-comment
  (korma/entity-fields :content :date :user)
  (korma/has-one image))
