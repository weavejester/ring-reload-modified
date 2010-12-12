(ns ring.middleware.reload-modified
  (:use [ring.util.tracker :only (tracker)]
        [clojure.java.io :only (file)]))

(defn wrap-reload-modified
  "Ring middleware that automatically reloads any source file that has been
  modified since the last request."
  [handler source-dirs]
  (let [now (System/currentTimeMillis)
        sources (map file source-dirs)
        get-namespaces (tracker sources now)]
    (fn [request]
      (doseq [ns-sym (get-namespaces)]
        (require ns-sym :reload))
      (handler request))))
