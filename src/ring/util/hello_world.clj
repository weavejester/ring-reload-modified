(ns ring.util.hello-world)

(defn handler [request]
  {:status 200
   :headers {"Content-Type" "text/plain"}
   :body "Hello World"})
