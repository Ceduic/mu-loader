(ns mu-loader.main
  (:require [compojure.core :refer :all]
            [compojure.route :as route]
            [ring.middleware.defaults :refer [site-defaults
                                              wrap-defaults]]
            [ring.util.response :as resp]))

(defroutes app-routes
  ;; Serve static files required for front
  (GET  "/" [] (resp/content-type
                 (resp/resource-response "index.html" {:root "public"}) "text/html"))
  (route/not-found "Not Found"))

(def app
  (wrap-defaults app-routes site-defaults))
