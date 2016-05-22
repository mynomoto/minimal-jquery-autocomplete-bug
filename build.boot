(set-env!
 :dependencies '[[adzerk/boot-cljs          "1.7.228-1"]
                 [adzerk/boot-reload        "0.4.7"]
                 [tailrecursion/boot-hoplon        "0.1.0-SNAPSHOT"]
                 [tailrecursion/hoplon             "6.0.0-alpha1"]
                 [cljsjs/jquery               "2.2.2-0"]
                 [cljsjs/jquery-ui            "1.11.4-0"]
                 [org.clojure/clojure       "1.8.0"]
                 [org.clojure/clojurescript "1.8.51"]
                 [tailrecursion/boot-jetty  "0.1.0"]]
  :source-paths #{"src"}
  :asset-paths  #{"assets"})

(require
  '[adzerk.boot-cljs         :refer [cljs]]
  '[adzerk.boot-reload       :refer [reload]]
  '[tailrecursion.boot-hoplon       :refer [hoplon prerender]]
  '[tailrecursion.boot-jetty :refer [serve]])

(deftask dev
  "Build jquery-ui-bug for local development."
  []
  (comp
    (watch)
    (speak)
    (hoplon)
    (reload)
    (cljs)
    (serve :port 8000)))

(deftask prod
  "Build jquery-ui-bug for production deployment."
  []
  (comp
    (hoplon)
    (cljs :optimizations :advanced)
    (prerender)))
