(defproject mu-loader "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :min-lein-version "2.0.0"
  :dependencies [[org.clojure/clojure "1.7.0"]
                 [compojure "1.4.0"]
                 [ragtime "0.5.2"]
                 [korma "0.4.2"]
                 [com.h2database/h2 "1.3.170"]
                 [ring/ring-defaults "0.1.5"]]
  :plugins [[lein-ring "0.9.7"]]
  :ragtime {:migrations ragtime.sql.files/resources/migrations
            :database "jdbc:h2:./resources/db/mu_loader.h2.db"}
  :ring {:handler mu-loader.main/app
         :auto-reload? true
         :auto-refresh? true}
  :profiles
  {:dev {:dependencies [[javax.servlet/servlet-api "2.5"]
                        [ring/ring-mock "0.3.0"]
                        [ring/ring-json "0.4.0"]]
         :plugins [[com.jakemccrary/lein-test-refresh "0.12.0"]]}})
