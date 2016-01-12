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
                 (resp/resource-response "index.html"
                                         {:root "public"}) "text/html"))

  ;;; Public API for REST operations
  ;; Request images based on a set of parameters
  (GET "/api/images" [:as {parameters :params}]
            {:status 200
             :body (images/get-images parameters)})

  ;; Request data for an image based on a set of parameters
  (GET "/api/images/:id{[0-9]+}" [id]
            {:status 200
             :body {:info (images/get-image id)
                    :comments (comments/get-comments id)}})

  (POST "/api/images" [:as {parameters :params}]
        {:status 201
         :headers {"location" "/null"}})

  (route/not-found "Not Found"))

(def app
  (-> app-routes
    ; Disabled CSRF protection for development
    ; (wrap-defaults site-defaults)
    (middleware/wrap-json-body)
    (middleware/wrap-json-params)
    (middleware/wrap-json-response)))
