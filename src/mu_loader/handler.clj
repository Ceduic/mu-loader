(ns mu-loader.handler
  (:require [compojure.core :refer :all]
            [compojure.route :as route]
            [ring.middleware.defaults :refer [site-defaults
                                              wrap-defaults]]
            [ring.util.response :as resp]))

(defroutes app-routes
  (GET  "/" [] (resp/content-type
                 (resp/resource-response "index.html" {:root "public"}) "text/html"))
  (route/not-found "Not Found"))

(def app
  (wrap-defaults app-routes site-defaults))
