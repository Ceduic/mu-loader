(ns mu-loader.main-test
  (:require [clojure.test :refer :all]
            [ring.mock.request :as mock]
            [mu-loader.main :refer :all]))

(deftest test-app
  (testing "main route"
    (let [response (app (mock/request :get "/"))]
      (println response)
      (is (= (:status response) 200))
      (is (= (:Content-Type "text/html")))))

  (testing "not-found route"
    (let [response (app (mock/request :get "/invalid"))]
      (is (= (:status response) 404)))))
