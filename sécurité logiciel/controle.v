(*============================== HADJOUDJA BACHIR GROUPE C Num etudiant : 21811363 ==============================================*)
(*============================== EXO 1 ==============================================*)
Parameters E : Set.
Parameters P Q : E -> Prop.
Parameters a : E.
Goal (exists x: E, (P x)) /\ (forall x: E, (P x) -> (Q x)) -> exists x: E, (Q x).
Proof.
intros.
elim H.
intros.
elim H0.
intros.
exists x.
apply H.
assumption.
Qed.


Goal (exists x:E, (P x) /\ (Q x)) -> (exists x:E, (P x) ->  (Q x)).
Proof.
intros.
elim H.
intros.
exists x.
elim H0.
intros.
assumption.
Qed.
(* Ou bien *)
Goal (exists x:E, (P x) /\ (Q x)) -> (exists x:E, (P x)->  (Q x)).
Proof.
intros.
elim H.
intros.
elim H0.
exists x.
intro.
assumption.
Qed.


(*============================== EXO 2 ==============================================*)
Parameter R : Set .
Parameters zero one : R.
Parameter opp : R -> R.
Parameters plus mult : R -> R -> R.
Section Commutative_ring .
Variables a b c : R.
Axiom ass_plus : plus (plus a b) c = plus a (plus b c) .
Axiom com_plus : plus a b = plus b a .
Axiom com_mult : mult a b = mult b a .
Axiom ass_mult : mult (mult a b) c = mult a ( mult b c ) .
Axiom dis_left : mult a (plus b c) = plus (mult a b ) (mult a c ) .
Axiom dis_right : mult ( plus b c ) a = plus (mult b a ) (mult c a ) .


Axiom neu_plus_r : plus a zero = a .
Axiom neu_plus_l : plus zero a = a .
Axiom neu_mult_r : mult a one = a .
Axiom neu_mult_l : mult one a = a .
Axiom opp_right : plus a ( opp a ) = zero .
Axiom opp_left : plus ( opp a ) a = zero .
End Commutative_ring .

Goal forall a b: R, (mult (plus a b) (plus one one)) = (plus b (plus  a (plus b a))).
Proof.
intros.
rewrite dis_left.
rewrite neu_mult_r.
rewrite ass_plus.
rewrite com_plus.
rewrite ass_plus.
rewrite (com_plus (plus a0 b) a0).
rewrite (com_plus a0 b).
reflexivity.
Qed.

(*============================== EXO 3 ==============================================*)


Require Export List. 
Open Scope list_scope. 
Import ListNotations .
Inductive is_length : list nat ->  nat -> Prop :=
| is_length_nil : is_length nil 0
| is_length_cons : forall (n e : nat) (l: list nat),
is_length l n -> is_length (e::l) (S n).

Fixpoint length (l : list nat) {struct l} : nat := match l with
|nil=> 0
| e::q => S (length q) 
end.

Lemma correction: forall l : list nat, forall n: nat,  (length l) = n -> (is_length l n).
Proof.
induction l.
intros.
rewrite <- H. 
simpl.
apply is_length_nil.
intros.
rewrite <- H.
simpl.
apply is_length_cons.
apply IHl.
reflexivity.
Qed.







