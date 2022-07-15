package com.example.androidspringboot.models;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
public class Formulaire {
    @Id
    private long id_formulaire;

    @Column(name = "NOM")
    private String nom;
    @Column(name = "Prenom")
    private String prenom;
    @Column(name = "Date")
    private String Date;
    @Column(name = "Numero")
    private String num;
    @Column(name = "mail")
    private String mail;
    @Column(name = "hobbit")
    @OneToMany(mappedBy = "form", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Hobbit> hobbit;



    public Formulaire(long id_formulaire, String nom, String prenom, String date, String num, String mail){
        this.id_formulaire = id_formulaire;
        this.nom = nom;
        this.prenom = prenom;
        this.Date = date;
        this.num = num;
        this.mail = mail;
        this.hobbit = hobbit;
    }

    public Formulaire() {

    }
    public long getId_formulaire() {
        return id_formulaire;
    }

    public void setId_formulaire(long id_formulaire) {
        this.id_formulaire = id_formulaire;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public List<Hobbit> getHobbit() {
        return hobbit;
    }

    public void setHobbit(List<Hobbit> hobbit) {
        this.hobbit = hobbit;
    }
}
