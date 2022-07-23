

Exercice 1
1)  
((lambda (x) (+ (* 2 x) 3)) 4)
2*4+3 = 11

2)
((lambda (x y) (* (+ x 2) (+ y 6))) 7 8) 
(7+2)*(8+6) = 126

3)
((lambda (v) ((lambda (x) (* 3 x)) (+ v 2))) 8)
(3* (8+2))=30

4)
((lambda (v) ((lambda (x) (* v x)) (+ v 2))) 8) 
8*(8+2) = 80

5)
((lambda (v) ((lambda (v) (* 3 v)) (+ v 2))) 8) 
3*(8+2) = 30


6)
((lambda (x y z) (+ (* x y) (* y z))) 2 3 4)
(2*3)+(3*4) =18

7)
((lambda (x y) (* x x y y)) 4) 
erreur on passe 1 chiffre pour 2 argument

8)
((lambda (x) (* x x 2)) 4 5) 
erreur on passe 2 chiffre a 1 argument

9)
(lambda (x) (* x x 2))
définition de fonction


Exercice 2
(defun f (x) (+ 3 x))
(defun g (v) (* 5 (f (+ v 2))))
évaluer (g 8)

(3+(8+2))*5 = 65

2)
(defun f (x) (+ v x))
(defun g (v) (* 5 (f (+ v 2))))
parce que v est local dans g

(defun fact(n) (if(= n 0)
        1
        ( * n (fact(- n 1)))))


3)

(defun fibo(n) (if(<= n 1)
        n
        ( + (fibo(- n 1))  (fibo(- n 2) ))))
le temps en compléxité est expodentiel












