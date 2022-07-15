(*exercice 1*)

Require Export List. 
Open Scope list_scope. 
Import ListNotations .
Inductive is_fact :  nat ->  nat -> Prop :=
| is_fact0 : is_fact 0 1
| is_fact_S : forall n s : nat,is_fact n s -> is_fact (S n) (n*s).

Fixpoint fact  (n : nat) : nat :=
match n with
|0=>1
|(S n) => (fact n) * n
end.




Require Import FunInd.
Functional Scheme fact_ind := Induction for fact Sort Prop.

Print fact_ind.



(*Exercice2*)

Inductive is_even : nat -> Prop :=
| is_even_0 : is_even 0
| is_even_S : forall n : nat,is_even n -> is_even (S(S n)).


Fixpoint fis_even  (n : nat) : Prop :=
match n with
|0=> True
|1=> False
|(S(S n)) => (fis_even n)
end.



Eval compute in (fis_even 4).

Require Import FunInd.
Functional Scheme fis_evenu_ind := Induction for fis_even Sort Prop.



Lemma exo2_3: forall (n: nat),  (fis_even n) = True -> is_even n.
Proof.
intro.
functional induction (fis_even n) using fis_evenu_ind; intros.
apply is_even_0.
elimtype False.
rewrite H.
auto.
apply is_even_S.
apply (IHP H).
Qed.

(*
Lemma exo2_4: forall (n: nat),  (fis_even n) = False -> ~(is_even n).
Proof.
intro.
functional induction (fis_even n) using fis_evenu_ind; intros.


apply is_even_0.
rewrite H.
auto.
apply is_even_S.
apply (IHP H).
Qed.
*)
Require Export Arith.
Require Export Recdef.
Require Export OmegaLemmas.
Require Export PreOmega.
Require Import ZArith.
Definition f_gcd (a b : nat * nat) :=
(fst a) + (snd a) < (fst b) + (snd b).


Function gcd (c : nat * nat) {wf f_gcd c} : option nat :=
match c with
| (0, 0) => None
| (0, _) => None
| (_, 0) => None
| _ =>
let n := fst c in
let m := snd c in
match (lt_eq_lt_dec n m) with
| inleft a =>
match a with
| left _ => gcd (n, (m - n))
| right _ => Some n
end
| inright a => gcd ((n - m), m)
end
end.


 Print lt_eq_lt_dec.
Print sumor.

intros.
unfold f_gcd.
simpl.
omega.