(ns tutorial-client.html-templates
  (:use [io.pedestal.app.templates :only [tfn dtfn tnodes]]))

(defmacro tutorial-client-templates
  []
  {;; template tutorial part 1
   #_:tutorial-client-page #_(dtfn (tnodes "tutorial-client.html" "tutorial" [[:#other-counters]])
                               #{:id})
   #_:other-counter #_(dtfn (tnodes "tutorial-client.html" "other-counter") #{:id})

   ;; template tutorial part 2
   :tutorial-client-page (dtfn (tnodes "game.html" "tutorial") #{:id})

   :login-page (tfn (tnodes "login.html" "login"))

   :wait-page (dtfn (tnodes "wait.html" "wait" [[:#players] [:#high-scores]]) #{:id})

   :player (tfn (tnodes "wait.html" "player"))

   :high-score (tfn (tnodes "wait.html" "high-score"))})




