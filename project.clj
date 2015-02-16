(defproject parenticket "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.6.0"]
                 [org.clojure/clojurescript "0.0-2850"]
                 [org.clojure/core.async "0.1.278.0-76b25b-alpha"]

                 [org.omcljs/om "0.8.9-SNAPSHOT" :exclusions [cljsjs/react]]
                 [cljsjs/react-with-addons "0.12.2-4" :exclusions [cljsjs/react]]

                 [com.cemerick/piggieback "0.1.6-SNAPSHOT"]
                 [weasel "0.6.0-SNAPSHOT"]]
  :plugins [[lein-cljsbuild "1.0.3"]
            [cider/cider-nrepl "0.8.2"]]
  :cljsbuild {:builds [{:id "client"
                        :source-paths ["src/"]
                        :compiler {:output-to "resources/public/main.js"
                                   :output-dir "resources/public/out/"
                                   :optimizations :whitespace
                                   :libs [""]
                                   :preamble ["react/react.min.js"]
                                   :externs ["react/externs/react.js"]}}]})
