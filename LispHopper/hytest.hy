(import [rhinoscriptsyntax :as rs])
(import [ghpythonlib.components :as ghcomp])
(import Rhino)
(require [hy.extra.anaphoric [*]])

(setv result_ [])


(print "hey hey!")

(print (+ 3 4 5))

(print (range 5))

(print (reduce (fn [a b] (+ a b)) (range 10)))

(print (reduce (xi + x1 x2) (range 10)))

(defn adder [n]
  (fn [x] (+ n x)))

(defn addthree [x]
  (adder 3))

(setv threeadder (addthree 3))

(print (threeadder 3))

(print (map threeadder (range 5)))

(->
  (list-comp
    (+ (str val) (str lim))
    (lim (range 5)
      val (range lim)))
  (print))

(defn flatt [list_of_lists]
  (import collections)
  (if (isinstance list_of_lists list)
    (list-comp
      val
      (sublist list_of_lists
        val sublist))
    list_of_lists))


(result_.append (rs.AddPoint 0 0 0))

(result_.append (rs.AddCircle (rs.AddPoint 0 0 2) 5))

(->
  (rs.AddPoint 0 0 4)
  (rs.AddCircle 5)
  (result_.append))

(ap-pipe
  (rs.AddPoint 0 0 6)
  (rs.AddCircle it 5)
  (result_.append it))


(defn moreCircles [circ n]
  (ap-pipe
    (rs.DivideCurve circ n)
    (map (xi rs.AddCircle x1 5) it)
    it))

(ap-pipe
  (rs.AddPoint 0 0 0)
  (rs.AddCircle it 5)
  (moreCircles it 5)
  (map (xi moreCircles x1 5) it)
  (flatt it)
  (map (xi moreCircles x1 5) it)
  (result_.append it))


(def ra result_.append)

(print (rs.AddPoint 0 50 0))

(defn makeBranch [b deg scl]
  (setv csp (rs.CurveStartPoint b))
  (setv cep (rs.CurveEndPoint b))
  (setv v (rs.VectorCreate cep csp))
  (setv yaxis (. (rs.WorldXYPlane) YAxis))
  (ap-pipe
    (rs.CopyObject b v)
    (rs.ScaleObject it cep [scl scl scl])
    (rs.RotateObject it cep deg yaxis)))

(defn makeTree [branch level]
  (if (= 0 level)
    branch
    [branch
      (makeTree (makeBranch branch -20 0.8) (- level 1))
      (makeTree (makeBranch branch 40 0.7) (- level 1))]))

(setv p1 (rs.AddPoint 0 0 0))
(setv p2 (rs.AddPoint 0 0 10))
(setv cc (rs.AddCurve [p1 p2]))

(ra
  (makeTree cc 9))

(print "hello world!")

