{:config {:order 0, :description "end of the game", :name :end-game}
 :data
 [
  [:node-create [] :map]
  [:node-create [:login] :map]
  [:node-create [:login :name] :map]
  [:transform-enable [:login :name] :login [{:io.pedestal.app.messages/type :swap, :io.pedestal.app.messages/topic [:login :name], :io.pedestal.app.messages.param/value {}} {:io.pedestal.app.messages/type :set-focus, :io.pedestal.app.messages/topic :io.pedestal.app.messages/app-model, :name :wait}]]
  :break
  [:value [:login :name] nil "michael"]
  :break
  [:value [:login :name] "michael" nil]
  [:transform-disable [:login :name] :login [{:io.pedestal.app.messages/type :swap, :io.pedestal.app.messages/topic [:login :name], :io.pedestal.app.messages.param/value {}} {:io.pedestal.app.messages/type :set-focus, :io.pedestal.app.messages/topic :io.pedestal.app.messages/app-model, :name :wait}]]
  [:node-destroy [:login :name] :map]
  [:node-destroy [:login] :map]
  [:node-create [:wait] :map]
  [:node-create [:wait :start] :map]
  [:transform-enable [:wait :start] :start-game [{:io.pedestal.app.messages/topic :io.pedestal.app.messages/output, :payload {:io.pedestal.app.messages/type :swap, :io.pedestal.app.messages/topic [:active-game], :value true}} {:io.pedestal.app.messages/type :swap, :io.pedestal.app.messages/topic [:active-game], :value true}]]
  [:node-create [:wait :counters] :map]
  [:node-create [:wait :counters "michael"] :map]
  :break
  [:node-create [:wait :counters "abc"] :map]
  [:value [:wait :counters "abc"] nil 0]
  :break
  [:node-create [:wait :counters "xyz"] :map]
  [:value [:wait :counters "xyz"] nil 0]
  :break
  [:value [:wait :counters "abc"] 0 1]
  :break
  [:value [:wait :counters "xyz"] 0 1]
  :break
  [:node-create [:main] :map]
  [:node-create [:main :my-counter] :map]
  [:transform-enable [:main :my-counter] :add-points [{:io.pedestal.app.messages/topic [:my-counter], :io.pedestal.app.messages.param/points {}}]]
  [:node-create [:main :total-count] :map]
  [:value [:main :total-count] nil 2]
  [:node-create [:main :average-count] :map]
  [:value [:main :average-count] nil 0.67]
  [:node-create [:main :max-count] :map]
  [:value [:main :max-count] nil 1]
  [:node-create [:main :counters] :map]
  [:node-create [:main :counters "abc"] :map]
  [:value [:main :counters "abc"] nil 1]
  [:node-create [:main :counters "michael"] :map]
  [:node-create [:main :counters "xyz"] :map]
  [:value [:main :counters "xyz"] nil 1]
  [:node-create [:main :player-order] :map]
  [:node-create [:main :player-order "xyz"] :map]
  [:value [:main :player-order "xyz"] nil 0]
  [:node-create [:main :player-order "abc"] :map]
  [:value [:main :player-order "abc"] nil 1]
  [:node-create [:main :player-order "michael"] :map]
  [:value [:main :player-order "michael"] nil 2]
  [:node-create [:main :clock] :map]
  [:value [:main :clock] nil 9]
  [:node-create [:main :add-bubbles] :map]
  [:value [:main :add-bubbles] nil {:clock 9, :count 3}]
  [:node-create [:main :remove-bubbles] :map]
  [:value [:main :remove-bubbles] nil {:total 2}]
  [:node-create [:pedestal] :map]
  [:node-create [:pedestal :debug] :map]
  [:node-create [:pedestal :debug :dataflow-time-max] :map]
  [:value [:pedestal :debug :dataflow-time-max] nil 31]
  [:node-create [:pedestal :debug :dataflow-time] :map]
  [:value [:pedestal :debug :dataflow-time] nil 30]
  [:node-create [:pedestal :debug :dataflow-time-avg] :map]
  [:value [:pedestal :debug :dataflow-time-avg] nil 16]
  :break
  [:value [:main :clock] 9 10]
  [:value [:main :add-bubbles] {:clock 9, :count 3} {:clock 10, :count 3}]
  [:value [:pedestal :debug :dataflow-time] 30 8]
  :break
  [:value [:wait :counters "abc"] 1 2]
  [:value [:main :total-count] 2 3]
  [:value [:main :average-count] 0.67 1]
  [:value [:main :max-count] 1 2]
  [:value [:main :counters "abc"] 1 2]
  [:value [:main :player-order "abc"] 1 0]
  [:value [:main :player-order "xyz"] 0 1]
  [:value [:main :remove-bubbles] {:total 2} {:total 3}]
  [:value [:pedestal :debug :dataflow-time] 8 28]
  [:value [:pedestal :debug :dataflow-time-avg] 16 17]
  :break
  [:value [:main :clock] 10 11]
  [:value [:main :add-bubbles] {:clock 10, :count 3} {:clock 11, :count 3}]
  [:value [:pedestal :debug :dataflow-time] 28 8]
  [:value [:pedestal :debug :dataflow-time-avg] 17 16]
  :break
  [:value [:wait :counters "abc"] 2 3]
  [:value [:main :total-count] 3 4]
  [:value [:main :average-count] 1 1.33]
  [:value [:main :max-count] 2 3]
  [:value [:main :counters "abc"] 2 3]
  [:value [:main :remove-bubbles] {:total 3} {:total 4}]
  [:value [:pedestal :debug :dataflow-time-max] 31 48]
  [:value [:pedestal :debug :dataflow-time] 8 48]
  [:value [:pedestal :debug :dataflow-time-avg] 16 18]
  :break
  [:value [:wait :counters "michael"] nil 300]
  [:node-create [:wait :winner] :map]
  [:value [:wait :winner] nil {:player "michael", :score 300}]
  [:node-create [:wait :high-scores] :map]
  [:value [:wait :high-scores] nil ({:player "michael", :score 300})]
  [:value [:main :total-count] 4 304]
  [:value [:main :average-count] 1.33 101.33]
  [:value [:main :max-count] 3 300]
  [:value [:main :counters "michael"] nil 300]
  [:value [:main :player-order "michael"] 2 0]
  [:value [:main :player-order "abc"] 0 1]
  [:value [:main :player-order "xyz"] 1 2]
  [:value [:pedestal :debug :dataflow-time-max] 48 108]
  [:value [:pedestal :debug :dataflow-time] 48 108]
  [:value [:pedestal :debug :dataflow-time-avg] 18 22]
  :break
  [:value [:wait :counters "michael"] 300 0]
  [:value [:main :total-count] 304 4]
  [:value [:main :average-count] 101.33 1.33]
  [:value [:main :counters "michael"] 300 0]
  [:value [:main :player-order "abc"] 1 0]
  [:value [:main :player-order "xyz"] 2 1]
  [:value [:main :player-order "michael"] 0 2]
  [:value [:pedestal :debug :dataflow-time] 108 35]
  [:value [:pedestal :debug :dataflow-time-avg] 22 23]
  :break
  [:value [:main :max-count] 300 0]
  [:value [:pedestal :debug :dataflow-time] 35 8]
  [:value [:pedestal :debug :dataflow-time-avg] 23 22]
  :break
  [:value [:wait :counters "abc"] 3 0]
  [:value [:main :total-count] 4 1]
  [:value [:main :average-count] 1.33 0.33]
  [:value [:main :max-count] 0 1]
  [:value [:main :counters "abc"] 3 0]
  [:value [:main :player-order "xyz"] 1 0]
  [:value [:main :player-order "michael"] 2 1]
  [:value [:main :player-order "abc"] 0 2]
  [:value [:main :remove-bubbles] {:total 4} {:total 1}]
  [:value [:pedestal :debug :dataflow-time] 8 34]
  [:value [:pedestal :debug :dataflow-time-avg] 22 23]
  :break
  [:value [:pedestal :debug :dataflow-time] 34 6]
  [:value [:pedestal :debug :dataflow-time-avg] 23 22]
  :break
  [:value [:wait :counters "xyz"] 1 0]
  [:value [:main :total-count] 1 0]
  [:value [:main :average-count] 0.33 0]
  [:value [:main :counters "xyz"] 1 0]
  [:value [:main :remove-bubbles] {:total 1} {:total 0}]
  [:value [:pedestal :debug :dataflow-time] 6 24]
  :break
  [:value [:main :counters "abc"] 0 nil]
  [:node-destroy [:main :counters "abc"] :map]
  [:value [:main :counters "michael"] 0 nil]
  [:node-destroy [:main :counters "michael"] :map]
  [:value [:main :counters "xyz"] 0 nil]
  [:node-destroy [:main :counters "xyz"] :map]
  [:node-destroy [:main :counters] :map]
  [:value [:main :clock] 11 nil]
  [:node-destroy [:main :clock] :map]
  [:transform-disable [:main :my-counter] :add-points [{:io.pedestal.app.messages/topic [:my-counter], :io.pedestal.app.messages.param/points {}}]]
  [:node-destroy [:main :my-counter] :map]
  [:value [:main :remove-bubbles] {:total 0} nil]
  [:node-destroy [:main :remove-bubbles] :map]
  [:value [:main :player-order "xyz"] 0 nil]
  [:node-destroy [:main :player-order "xyz"] :map]
  [:value [:main :player-order "abc"] 2 nil]
  [:node-destroy [:main :player-order "abc"] :map]
  [:value [:main :player-order "michael"] 1 nil]
  [:node-destroy [:main :player-order "michael"] :map]
  [:node-destroy [:main :player-order] :map]
  [:value [:main :add-bubbles] {:clock 11, :count 3} nil]
  [:node-destroy [:main :add-bubbles] :map]
  [:value [:main :average-count] 0 nil]
  [:node-destroy [:main :average-count] :map]
  [:value [:main :max-count] 1 nil]
  [:node-destroy [:main :max-count] :map]
  [:value [:main :total-count] 0 nil]
  [:node-destroy [:main :total-count] :map]
  [:node-destroy [:main] :map]
  [:value [:pedestal :debug :dataflow-time-max] 108 nil]
  [:node-destroy [:pedestal :debug :dataflow-time-max] :map]
  [:value [:pedestal :debug :dataflow-time] 24 nil]
  [:node-destroy [:pedestal :debug :dataflow-time] :map]
  [:value [:pedestal :debug :dataflow-time-avg] 22 nil]
  [:node-destroy [:pedestal :debug :dataflow-time-avg] :map]
  [:node-destroy [:pedestal :debug] :map]
  [:node-destroy [:pedestal] :map]
  :break
  [:value [:wait :counters "xyz"] 0 2]
  :break
  [:value [:wait :counters "abc"] 0 4]
  :break
  [:value [:wait :counters "abc"] 4 5]
  :break
  [:value [:wait :counters "abc"] 5 6]
  :break
  [:value [:wait :counters "xyz"] 2 3]
  :break
  [:node-create [:main] :map]
  [:node-create [:main :my-counter] :map]
  [:transform-enable [:main :my-counter] :add-points [{:io.pedestal.app.messages/topic [:my-counter], :io.pedestal.app.messages.param/points {}}]]
  [:node-create [:main :total-count] :map]
  [:value [:main :total-count] nil 9]
  [:node-create [:main :average-count] :map]
  [:value [:main :average-count] nil 3]
  [:node-create [:main :max-count] :map]
  [:value [:main :max-count] nil 6]
  [:node-create [:main :counters] :map]
  [:node-create [:main :counters "abc"] :map]
  [:value [:main :counters "abc"] nil 6]
  [:node-create [:main :counters "michael"] :map]
  [:value [:main :counters "michael"] nil 0]
  [:node-create [:main :counters "xyz"] :map]
  [:value [:main :counters "xyz"] nil 3]
  [:node-create [:main :player-order] :map]
  [:node-create [:main :player-order "abc"] :map]
  [:value [:main :player-order "abc"] nil 0]
  [:node-create [:main :player-order "xyz"] :map]
  [:value [:main :player-order "xyz"] nil 1]
  [:node-create [:main :player-order "michael"] :map]
  [:value [:main :player-order "michael"] nil 2]
  [:node-create [:main :clock] :map]
  [:value [:main :clock] nil 13]
  [:node-create [:main :add-bubbles] :map]
  [:value [:main :add-bubbles] nil {:clock 13, :count 3}]
  [:node-create [:main :remove-bubbles] :map]
  [:value [:main :remove-bubbles] nil {:total 9}]
  [:node-create [:pedestal] :map]
  [:node-create [:pedestal :debug] :map]
  [:node-create [:pedestal :debug :dataflow-time-max] :map]
  [:value [:pedestal :debug :dataflow-time-max] nil 108]
  [:node-create [:pedestal :debug :dataflow-time] :map]
  [:value [:pedestal :debug :dataflow-time] nil 23]
  [:node-create [:pedestal :debug :dataflow-time-avg] :map]
  [:value [:pedestal :debug :dataflow-time-avg] nil 21]
  :break
  [:value [:main :clock] 13 14]
  [:value [:main :add-bubbles] {:clock 13, :count 3} {:clock 14, :count 3}]
  [:value [:pedestal :debug :dataflow-time] 23 16]
  :break
  [:value [:wait :counters "abc"] 6 7]
  [:value [:main :total-count] 9 10]
  [:value [:main :average-count] 3 3.33]
  [:value [:main :max-count] 6 7]
  [:value [:main :counters "abc"] 6 7]
  [:value [:main :remove-bubbles] {:total 9} {:total 10}]
  [:value [:pedestal :debug :dataflow-time] 16 34]
  :break
  [:value [:wait :counters "xyz"] 3 4]
  [:value [:main :total-count] 10 11]
  [:value [:main :average-count] 3.33 3.67]
  [:value [:main :counters "xyz"] 3 4]
  [:value [:main :remove-bubbles] {:total 10} {:total 11}]
  [:value [:pedestal :debug :dataflow-time] 34 20]
  :break
  [:value [:wait :counters "abc"] 7 8]
  [:value [:main :total-count] 11 12]
  [:value [:main :average-count] 3.67 4]
  [:value [:main :max-count] 7 8]
  [:value [:main :counters "abc"] 7 8]
  [:value [:main :remove-bubbles] {:total 11} {:total 12}]
  [:value [:pedestal :debug :dataflow-time] 20 22]
  :break
  [:value [:main :clock] 14 15]
  [:value [:main :add-bubbles] {:clock 14, :count 3} {:clock 15, :count 3}]
  [:value [:pedestal :debug :dataflow-time] 22 7]
  :break
  [:value [:wait :counters "abc"] 8 9]
  [:value [:main :total-count] 12 13]
  [:value [:main :average-count] 4 4.33]
  [:value [:main :max-count] 8 9]
  [:value [:main :counters "abc"] 8 9]
  [:value [:main :remove-bubbles] {:total 12} {:total 13}]
  [:value [:pedestal :debug :dataflow-time] 7 22]
  :break
  [:value [:wait :counters "abc"] 9 10]
  [:value [:main :total-count] 13 14]
  [:value [:main :average-count] 4.33 4.67]
  [:value [:main :max-count] 9 10]
  [:value [:main :counters "abc"] 9 10]
  [:value [:main :remove-bubbles] {:total 13} {:total 14}]
  [:value [:pedestal :debug :dataflow-time] 22 23]
  :break
  [:value [:main :clock] 15 16]
  [:value [:main :add-bubbles] {:clock 15, :count 3} {:clock 16, :count 3}]
  [:value [:pedestal :debug :dataflow-time] 23 8]
  [:value [:pedestal :debug :dataflow-time-avg] 21 20]
  :break
  [:value [:wait :counters "xyz"] 4 5]
  [:value [:main :total-count] 14 15]
  [:value [:main :average-count] 4.67 5]
  [:value [:main :counters "xyz"] 4 5]
  [:value [:main :remove-bubbles] {:total 14} {:total 15}]
  [:value [:pedestal :debug :dataflow-time] 8 22]
  :break
  [:value [:wait :counters "abc"] 10 11]
  [:value [:main :total-count] 15 16]
  [:value [:main :average-count] 5 5.33]
  [:value [:main :max-count] 10 11]
  [:value [:main :counters "abc"] 10 11]
  [:value [:main :remove-bubbles] {:total 15} {:total 16}]
  [:value [:pedestal :debug :dataflow-time] 22 21]
  :break
  [:value [:wait :counters "michael"] 0 500]
  [:value [:wait :winner] {:player "michael", :score 300} {:player "michael", :score 500}]
  [:value [:wait :high-scores] ({:player "michael", :score 300}) ({:player "michael", :score 500} {:player "michael", :score 300})]
  [:value [:main :total-count] 16 516]
  [:value [:main :average-count] 5.33 172]
  [:value [:main :max-count] 11 500]
  [:value [:main :counters "michael"] 0 500]
  [:value [:main :player-order "michael"] 2 0]
  [:value [:main :player-order "abc"] 0 1]
  [:value [:main :player-order "xyz"] 1 2]
  [:value [:pedestal :debug :dataflow-time] 21 86]
  [:value [:pedestal :debug :dataflow-time-avg] 20 22]
  :break
  [:value [:wait :counters "michael"] 500 0]
  [:value [:main :total-count] 516 16]
  [:value [:main :average-count] 172 5.33]
  [:value [:main :counters "michael"] 500 0]
  [:value [:main :player-order "abc"] 1 0]
  [:value [:main :player-order "xyz"] 2 1]
  [:value [:main :player-order "michael"] 0 2]
  [:value [:pedestal :debug :dataflow-time] 86 28]
  :break
  [:value [:main :max-count] 500 0]
  [:value [:pedestal :debug :dataflow-time] 28 6]
  :break
  [:value [:wait :counters "abc"] 11 0]
  [:value [:main :total-count] 16 5]
  [:value [:main :average-count] 5.33 1.67]
  [:value [:main :max-count] 0 5]
  [:value [:main :counters "abc"] 11 0]
  [:value [:main :player-order "xyz"] 1 0]
  [:value [:main :player-order "michael"] 2 1]
  [:value [:main :player-order "abc"] 0 2]
  [:value [:main :remove-bubbles] {:total 16} {:total 5}]
  [:value [:pedestal :debug :dataflow-time] 6 40]
  :break
  [:value [:pedestal :debug :dataflow-time] 40 1]
  :break
  [:value [:wait :counters "xyz"] 5 0]
  [:value [:main :total-count] 5 0]
  [:value [:main :average-count] 1.67 0]
  [:value [:main :counters "xyz"] 5 0]
  [:value [:main :remove-bubbles] {:total 5} {:total 0}]
  [:value [:pedestal :debug :dataflow-time] 1 26]
  :break
  [:value [:main :counters "abc"] 0 nil]
  [:node-destroy [:main :counters "abc"] :map]
  [:value [:main :counters "michael"] 0 nil]
  [:node-destroy [:main :counters "michael"] :map]
  [:value [:main :counters "xyz"] 0 nil]
  [:node-destroy [:main :counters "xyz"] :map]
  [:node-destroy [:main :counters] :map]
  [:value [:main :clock] 16 nil]
  [:node-destroy [:main :clock] :map]
  [:transform-disable [:main :my-counter] :add-points [{:io.pedestal.app.messages/topic [:my-counter], :io.pedestal.app.messages.param/points {}}]]
  [:node-destroy [:main :my-counter] :map]
  [:value [:main :remove-bubbles] {:total 0} nil]
  [:node-destroy [:main :remove-bubbles] :map]
  [:value [:main :player-order "abc"] 2 nil]
  [:node-destroy [:main :player-order "abc"] :map]
  [:value [:main :player-order "xyz"] 0 nil]
  [:node-destroy [:main :player-order "xyz"] :map]
  [:value [:main :player-order "michael"] 1 nil]
  [:node-destroy [:main :player-order "michael"] :map]
  [:node-destroy [:main :player-order] :map]
  [:value [:main :add-bubbles] {:clock 16, :count 3} nil]
  [:node-destroy [:main :add-bubbles] :map]
  [:value [:main :average-count] 0 nil]
  [:node-destroy [:main :average-count] :map]
  [:value [:main :max-count] 5 nil]
  [:node-destroy [:main :max-count] :map]
  [:value [:main :total-count] 0 nil]
  [:node-destroy [:main :total-count] :map]
  [:node-destroy [:main] :map]
  [:value [:pedestal :debug :dataflow-time-max] 108 nil]
  [:node-destroy [:pedestal :debug :dataflow-time-max] :map]
  [:value [:pedestal :debug :dataflow-time] 26 nil]
  [:node-destroy [:pedestal :debug :dataflow-time] :map]
  [:value [:pedestal :debug :dataflow-time-avg] 22 nil]
  [:node-destroy [:pedestal :debug :dataflow-time-avg] :map]
  [:node-destroy [:pedestal :debug] :map]
  [:node-destroy [:pedestal] :map]
  :break
  [:value [:wait :counters "abc"] 0 12]
  :break
  [:value [:wait :counters "xyz"] 0 6]
  :break
  [:value [:wait :counters "abc"] 12 13]
  :break
  [:value [:wait :counters "abc"] 13 14]
 ]}