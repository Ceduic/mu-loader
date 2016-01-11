;;; Define database and other shared settings

(ns mu-loader.components.db
  (:require [korma.db :refer [defdb]]))


(def db {:classname   "org.h2.Driver"
         :subprotocol "h2"
         :subname     "resources/db/korma.db"})

(defdb database db)
