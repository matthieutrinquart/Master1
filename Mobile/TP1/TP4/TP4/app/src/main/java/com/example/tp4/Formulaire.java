package com.example.tp4;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.room.Entity;


public class Formulaire implements Parcelable {
    private String nom;
    private String prenom;
    private String age;
    private String num;
    private String mdp;

    public Formulaire(String nom, String prenom, String age, String num, String mdp) {
        this.nom = nom;
        this.prenom = prenom;
        this.age = age;
        this.num = num;
        this.mdp = mdp;
    }

    protected Formulaire(Parcel in) {
        nom = in.readString();
        prenom = in.readString();
        age = in.readString();
        num = in.readString();
        mdp = in.readString();
    }

    public static final Creator<Formulaire> CREATOR = new Creator<Formulaire>() {
        @Override
        public Formulaire createFromParcel(Parcel in) {
            return new Formulaire(in);
        }

        @Override
        public Formulaire[] newArray(int size) {
            return new Formulaire[size];
        }
    };

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

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public String getMdp() {
        return mdp;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(nom);
        parcel.writeString(prenom);
        parcel.writeString(age);
        parcel.writeString(num);
        parcel.writeString(mdp);
    }
}
