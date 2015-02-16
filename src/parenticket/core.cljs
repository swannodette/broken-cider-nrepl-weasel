(ns parenticket.core
  (:require [om.core :as om :include-macros true]
            [om.dom :as dom :include-macros true]

            [weasel.repl :as ws-repl]

            [cljs.core.async :as async])
  (:require-macros [cljs.core.async.macros :refer [go-loop]]))

(enable-console-print!)
(ws-repl/connect "ws://localhost:9003" :verbose true)

(def app-state (atom {}))

(defn foo [state owner]
  (reify
    om/IWillMount
    (will-mount [_]
      (go-loop []
        (<! (async/timeout 1000))
        (println "println")
        (println "another println")
        (recur)))
    om/IRender
    (render [_]
      (dom/div #js {:onClick #(do (println "click!") false)}
               "Click me"))))

(om/root foo app-state {:target (js/document.getElementById "main")})


(js/alert 42)
