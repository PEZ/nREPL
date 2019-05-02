(ns clojure.live-hacking)

(comment
  (require '[nrepl.server :refer [start-server stop-server]])
  (def server (start-server :port 7888))
  (require '[nrepl.core :as nrepl])
  (with-open [conn (nrepl/connect :port 7888)] xx
             (-> (nrepl/client conn 1000)    ; message receive timeout required
        ;(nrepl/message {:op "eval" :code "(figwheel.main.api/cljs-repl :dev)"})
                 (nrepl/message {:op "eval" :code "(+ 1 1)"})
                 nrepl/response-values))
  (stop-server server)

  (require '[nrepl.middleware.print :as nprint])
  nprint/printing-log
  nprint/foo
  nprint/printing-transport

  (require '[figwheel.main.api :as fapi])
  (fapi/cljs-repl "dev")
  (+ 1 1)
  (println 1)

  (js/console.log "Hello")

  (require 'cljs.repl.nashorn)
  (cider.piggieback/cljs-repl (cljs.repl.nashorn/repl-env))
  (+ 1 1)
  (enable-console-print!)
  (println "hello")
  :cljs/quit

  (require 'figwheel.main.api)
  (figwheel.main.api/start "dev")
  (figwheel.main.api/cljs-repl "dev")
  (+ 1 1)
  (enable-console-print!)
  (println "hello")
  :cljs/quit)