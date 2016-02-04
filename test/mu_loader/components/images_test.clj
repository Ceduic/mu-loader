(ns mu-loader.components.images-test
  (:require [clojure.test :refer :all]
            [mu-loader.components.images :refer :all]))

(println "Testing images...")

(def test-data [{:img-url "/data/images/test.jpg"
                 :user "John"}
                {:img-url "/data/images/test.jpg"
                 :user "Mike"}
                {:img-url "/data/images/test.jpg"
                 :user "Lily"}
                {:img-url "/data/images/test.jpg"
                 :user "Foo"}
                {:img-url "/data/images/test.jpg"
                 :user "Bar"}
                {:img-url "/data/images/test.jpg"
                 :user "Baric"}
                {:img-url "/data/images/test.jpg"
                 :user "Mr. Foo"}
                {:img-url "/data/images/test.jpg"
                 :user "Herr. öääööå%"}
                {:img-url "/data/images/test.jpg"
                 :user "¤#¤#¤#¤#"}])

(deftest images-test
  (testing "Saving dummy data"
    (doseq [entry test-data]
      (println "Saving entry...")
      (let [id (create-entry entry)]
        (is (= (:user entry) (:user (get-entry id))))))))
