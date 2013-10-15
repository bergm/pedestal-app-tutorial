(ns tutorial-client.rendering
  (:require [domina :as dom]
            [io.pedestal.app.render.push :as render]
            [io.pedestal.app.render.push.templates :as templates]
            [io.pedestal.app.render.push.handlers.automatic :as d]
            [io.pedestal.app.render.push.handlers :as h]
            [io.pedestal.app.render.events :as events])
  (:require-macros [tutorial-client.html-templates :as html-templates]))

(def templates (html-templates/tutorial-client-templates))


;; tutorial part 1 rendering

(defn render-template [template-name initial-value-fn]
  (fn [renderer [_ path :as delta] input-queue]
    (let [parent (render/get-parent-id renderer path)
          id (render/new-id! renderer path)
          html (templates/add-template renderer path (template-name templates))]
      (dom/append! (dom/by-id parent) (html (assoc (initial-value-fn delta) :id id))))))

(defn render-value [renderer [_ path _ new-value] input-queue]
  (let [key (last path)]
    (templates/update-t renderer [:main] {key (str new-value)})))

(defn render-other-counters-element [renderer [_ path] _]
  (render/new-id! renderer path "other-counters"))

(defn render-other-counter-value [renderer [_ path _ new-value] input-queue]
  (let [key (last path)]
    (templates/update-t renderer path {:count (str new-value)})))

#_(defn render-config []
  [[:node-create [:main] (render-template :tutorial-client-page
                                          (constantly {:my-counter "0"}))]
   [:node-destroy [:main] h/default-destroy]

   [:transform-enable [:main :my-counter] (h/add-send-on-click "inc-button")]
   [:transform-disable [:main :my-counter] (h/remove-send-on-click "inc-button")]

   [:value [:main :*] render-value]
   [:value [:pedestal :debug :*] render-value]

   [:node-create [:main :other-counters] render-other-counters-element]
   [:node-create [:main :other-counters :*]
    (render-template :other-counter
                     (fn [[_ path]] {:counter-id (last path)}))]
   [:node-destroy [:main :other-counters :*] h/default-destroy]
   [:value [:main :other-counters :*] render-other-counter-value]])



;; game rendering

;; login

(defn add-login-template [renderer [_ path :as delta] input-queue]
  (let [parent (render/get-parent-id renderer path)
        id (render/new-id! renderer path)
        html (:login-page templates)]
    (dom/append! (dom/by-id parent) (html {:id id}))))

(defn add-submit-login-handler [_ [_ path transform-name messages] input-queue]
  (events/collect-and-send :click "login-button" input-queue transform-name messages
                           {"login-name" :value}))

(defn remove-submit-login-event [_ _ _]
  (events/remove-click-event "login-button"))

;; main

(defn add-template [renderer [_ path :as delta] input-queue]
  (let [parent (render/get-parent-id renderer path)
        id (render/new-id! renderer path)
        html (templates/add-template renderer path (:tutorial-client-page templates))]
    (dom/append! (dom/by-id parent) (html {:id id}))
    (let [g (js/BubbleGame. "game-board")]
      (render/set-data! renderer path g)
      (dotimes [_ 5] (.addBubble g)))))

(defn game [renderer]
  (render/get-data renderer [:main]))

(defn destroy-game [renderer [_ path :as delta] input-queue]
  (.destroy (game renderer))
  (render/drop-data! renderer path)
  (h/default-destroy renderer delta input-queue))

(defn add-player [renderer [_ path] _]
  (.addPlayer (game renderer) (last path)))

;; tutorial part 1
#_(defn set-score [renderer [_ path _ v] _]
  (let [n (last path)
        g (game renderer)]
    (.setScore g n v)
    (when (not= n "Me")
      (.removeBubble g))))

;; tutorial part 2
(defn set-score [renderer [_ path _ v] _]
  (.setScore (game renderer) (last path) v))

(defn set-stat [renderer [_ path _ v] _]
  (let [s (last path)]
    (if-let [g (game renderer)]
      (.setStat g (name s) v))))

(defn add-handler [renderer [_ path transform-name messages] input-queue]
  (.addHandler (game renderer)
               (fn [p]
                 (events/send-transforms input-queue transform-name messages {:points p}))))

(defn set-player-order [renderer [_ path _ v] _]
  (let [n (last path)]
    (.setOrder (game renderer) n v)))

(defn add-bubbles [renderer [_ path _ v] _]
  (dotimes [x (:count v)]
    (.addBubble (game renderer))))

(defn remove-bubbles [renderer _ _]
  (.removeBubble (game renderer)))

(defn add-wait-template [renderer [_ path :as delta] input-queue]
  (let [parent (render/get-parent-id renderer path)
        id (render/new-id! renderer path)
        html (templates/add-template renderer path (:wait-page templates))]
    (dom/append! (dom/by-id parent) (html {:id id}))))

(defn add-waiting-player [renderer [_ path :as delta] input-queue]
  (let [parent (render/new-id! renderer (vec (butlast path)) "players")
        id (render/new-id! renderer path)
        html (:player templates)]
    (dom/append! (dom/by-id parent) (html {:id id :player-name (last path)}))))

(defn render-winner [renderer [_ path _ v] _]
  (templates/update-t renderer [:wait]
                      {:winner (str (:player v) " wins with a score of " (:score v))}))

(defn render-high-scores [renderer [_ path _ v] _]
  (let [t (:high-score templates)
        high-scores (apply str
                           (map (fn [{:keys [player score]}]
                                  (t {:player-name player :player-score score})) v))]
    (templates/update-t renderer [:wait]
                        {:high-scores high-scores})))


(defn render-config []
  [[:node-create  [:login] add-login-template]
   [:node-destroy [:login] h/default-destroy]
   [:transform-enable [:login :name] add-submit-login-handler]
   [:transform-disable [:login :name] remove-submit-login-event]

   [:node-create  [:wait] add-wait-template]
   [:node-destroy [:wait] h/default-destroy]
   [:transform-enable [:wait :start] (h/add-send-on-click "start-button")]
   [:transform-disable [:wait :start] (h/remove-send-on-click "start-button")]
   [:node-create [:wait :counters :*] add-waiting-player]
   [:node-destroy [:wait :counters :*] h/default-destroy]
   [:value [:wait :winner] render-winner]
   [:value [:wait :high-scores] render-high-scores]

   [:node-create [:main] add-template]
   [:node-destroy [:main] destroy-game]
   [:node-create [:main :counters :*] add-player]
   [:value [:main :counters :*] set-score]
   [:value [:pedestal :debug :*] set-stat]
   [:value [:main :*] set-stat]
   [:value [:main :player-order :*] set-player-order]
   [:value [:main :add-bubbles] add-bubbles]
   [:value [:main :remove-bubbles] remove-bubbles]
   [:transform-enable [:main :my-counter] add-handler]])

