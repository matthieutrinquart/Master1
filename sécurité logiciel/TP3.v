
Fixpoint mult(n m : nat) : nat :=
  match n with
  | 0=>0
  |(S p) => (plus (mult p m) m)
  end.


Eval compute in (mult 2 3).



Lemma p1 : forall n , mult 2 n = plus n n.
Proof.
  intro.
  simpl.
  reflexivity.
Qed.

Lemma aux0 : forall n,
  (plus n 2) = S (S n).
Proof.
  induction n.
  simpl.
  reflexivity.
  simpl.
  rewrite IHn.
  reflexivity.
Qed.




Lemma aux1 : forall n m,
  (plus n (S m)) = S (plus n m).
Proof.
  induction n;intros.
  simpl.
  reflexivity.
  simpl.
  rewrite IHn.
  reflexivity.
Qed.


Lemma p2 : forall n, mult n 2 = plus n n.
Proof.
  intro.
  elim n.
  simpl.
  reflexivity.
  intros.
  simpl.
  rewrite H.
  rewrite aux0.
  rewrite aux1.
  reflexivity.
Qed.

Open Scope list.
Definition E := nat.

Fixpoint rev ( l :list E){struct l} : list E :=
  match l with
  | nil=>nil
  |e::q => (rev q) ++ (e::nil)
  end.


Theorem exo2_2 :
  forall l : list E,forall e :E,
    rev(l++(e::nil)) = e::rev(l).
Proof.
  induction l.
  simpl.
  reflexivity.
  intro.
  simpl.
  rewrite IHl.
  simpl.
  reflexivity.
Qed.


Open Scope list.
Definition E := nat.

Fixpoint rev ( l:list E){struct l} : list E:=
  match l with
  |nil => nil
  |e::q => (rev q) ++ (e::nil)
  end.



Theorem exo2_2 :
  forall l : list E,forall e :E, rev(l++(e::nil)) = e::rev(l). 
Proof.
induction l.
simpl.
reflexivity.
intro.
simpl.
rewrite IHl.
simpl.
reflexivity.
Qed.

Theorem exo2_3 :
forall l : list E, rev(rev(l))=l.
Proof.
induction l.
simpl.
reflexivity.
simpl.
intros.
rewrite IHl.
Qed.



