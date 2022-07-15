package com.example.androidspringboot.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
public class Hobbit {
    @Id
    private long id_hobbit;
    @Column(name = "NOM")
    private String nom;
    @Column(name = "val")
    private boolean val;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="hotel_id_hotel", nullable=false)
    public Formulaire form;

    public Hobbit(long id,String nom, boolean val , Formulaire re) {
        this.id_hobbit = id;
        this.nom = nom;
        this.val = val;
        this.form = re;
    }

    public Hobbit() {

    }

    public String getNom() {
        return nom;
    }

    public boolean isVal() {
        return val;
    }
    public void setForm(Formulaire f){
        this.form = f;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setVal(boolean val) {
        this.val = val;
    }
}
