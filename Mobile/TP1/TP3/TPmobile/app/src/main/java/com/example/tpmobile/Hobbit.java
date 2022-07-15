package com.example.tpmobile;

public class Hobbit {
    private long id;
    private String nom;
    private boolean val;

    public Hobbit(String nom, boolean val ,  long id) {
        this.nom = nom;
        this.val = val;
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public boolean isVal() {
        return val;
    }
}
