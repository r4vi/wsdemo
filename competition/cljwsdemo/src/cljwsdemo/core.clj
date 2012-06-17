(ns cljwsdemo.core (:gen-class))
(use 'aleph.http 'lamina.core)

(def broadcast-channel (channel))
(defn ws-handler [ch handshake]
  (receive ch 
           (fn [name]
             (siphon broadcast-channel ch))))

(defn -main
  "Starts the websocket server"
  [& args]
  (start-http-server ws-handler {:port 8080 :websocket true}))
