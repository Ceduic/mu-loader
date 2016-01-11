(ns mu-loader.main
  (:require [compojure.core :refer :all]
            [compojure.route :as route]
            [ring.middleware.defaults :refer [site-defaults
                                              wrap-defaults]]
            [ring.middleware.json :as middleware]
            [ring.util.response :as resp]
            [mu-loader.components.comments :as comments]
            [mu-loader.components.images :as images]))

(defroutes app-routes
  ;; Serve static files required for front
  (GET  "/" [] (resp/content-type
                 (resp/resource-response "index.html" {:root "public"}) "text/html"))

  ;;; Public API for REST operations
  ;; Request images based on a set of parameters
  (GET "/api/images" parameters (resp/content-type
                                  (do (println parameters)
                                    (images/get-images parameters)) "text/json"))
  ;; Request data for an image based on a set of parameters
  (GET "/api/images/:id{[0-9]+}" [id] {:status 200
                                       :body {:info (images/get-image id)
                                              :comments (comments/get-comments id)}})
  (route/not-found "Not Found"))

(def app
  (-> (wrap-defaults app-routes site-defaults)
      (middleware/wrap-json-body)
      (middleware/wrap-json-params)
      (middleware/wrap-json-response)))
