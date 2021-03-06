Parameters A B : Prop.

Lemma p1 : A->B->A.
Proof.
  intro.
  intro.
  assumption.
Qed.
Print p1.


Lemma p3 : A /\ B -> B.
Proof.
  intro.
  elim H.
  intros.
  assumption.
Qed.
(* Print p3. *)


Lemma p4 : B -> A \/ B.
Proof.
  intro.
  right.
  assumption.
Qed.
(* Print p4. *)


Parameters C : Prop.
Lemma p2 : (A -> B -> C) -> (A -> B) -> A -> C.
Proof.
  intros.
  apply H.
  assumption.
  apply H0.
  assumption.
  (* Show 2.    pour montrer un subgoal en detain *)
Qed.


Lemma p5 :  (A \/ B) -> (A -> C) -> (B -> C) -> C.
Proof.
  intros.
  elim H.
  assumption.
  assumption.
Qed.


Lemma p6 : A -> False -> ~A.
Proof.
  intros.
  elimtype False.
  assumption.
Qed.


Lemma p7 : False -> A.
Proof.
  intros.
  elimtype False.
  assumption.
Qed.


Lemma p8 : (A <-> B) -> A -> B.
Proof.
  intro.
  elim H.
  do 2 intro.
  assumption.
Qed.


Lemma p9 : (A <-> B) -> B -> A.
Proof.
  intro.
  elim H.
  do 2 intro.
  assumption.
Qed.


Lemma p10 : (A -> B) -> (B -> A) -> (A <-> B).
Proof.
  intros.
  split.
  assumption.
  assumption.
Qed.



(* Ex 2 *)
Parameters E : Set.
Parameters P Q : E -> Prop.

Lemma q1 : 
  forall x : E, (P x) -> exists y: E, (P y) \/ (Q y).
Proof.
  intro.
  intro.
  exists x.
  left.
  assumption.
Qed.


Lemma q2 : (exists x : E, (P x) \/ (Q x)) ->
           (exists x : E, (P x)) \/ 
           (exists x : E, (Q x)).
Proof.
  intro.
  elim H.
  intros.
  elim H0.
  left.
  exists x.
  assumption.
  right.
  exists x.
  assumption.
Qed.

(* (∀x.P (x)) ∧ (∀x.Q(x)) ⇒ ∀x.P (x) ∧ Q(x) *)
Lemma q3 : (forall x: E, (P x)) /\ (forall x:E, (Q x))
           -> forall x:E, (P x) /\ (Q x).
Proof.
  intros.
  elim H.
  intros.
  split.
  apply H0.
  apply H1.
Qed.


(*
Lemma q4 :   forall x:E, (P x) /\ (Q x)-> 
            (forall x: E, (P x)) /\ (forall x:E, (Q x)).
Proof.
  intros.
  elim H.
  split.
  intro.
  intro Q x.
  


Qed.
*)

(*     (∀x.¬P (x)) ⇒ ¬(∃x.P (x))      *)
Lemma q5 : (forall x:E, ~(P x)) -> ~(exists x:E, P x).
Proof.
  intro.
  intro.
  elim H0 ; intros.
  apply (H x).
  assumption.
Qed.

Lemma q6 : ~(forall x:E, (P x)) -> exists x:E, ~(P x).
Proof.
  intro.
  exists.


Qed.