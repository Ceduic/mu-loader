(ns mu-loader.main
  (:require [compojure.core :refer :all]
            [compojure.route :as route]
            [ring.middleware.defaults :refer [site-defaults
                                              wrap-defaults]]
            [ring.middleware.json :as jsonware]
            [ring.middleware.params :as paramsware]
            [ring.middleware.multipart-params :as multipware]
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
  (GET "/api/images" {parameters :params}
    {:status 200
     :body (images/get-images parameters)})

  ;; Request data for an image based on a set of parameters
  (GET "/api/images/:id{[0-9]+}" [id]
    {:status 200
     :body {:info (images/get-image id)
            :comments (comments/get-comments id)}})

  (POST "/api/images" {parameters :params}
    (let [file (:file parameters)
          saved? (images/save-image file)]
      {:status (if saved? 302 400)
       :headers {"Location" "/"}}))

  (route/not-found "Not Found"))

(def app
  (-> app-routes
    ; Disabled CSRF protection for development
      (wrap-defaults (assoc-in site-defaults [:security :anti-forgery] false))
      jsonware/wrap-json-body
      jsonware/wrap-json-params
      jsonware/wrap-json-response
      paramsware/wrap-params
      multipware/wrap-multipart-params))
