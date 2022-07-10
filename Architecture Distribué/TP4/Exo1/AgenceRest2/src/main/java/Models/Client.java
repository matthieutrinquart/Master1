package Models;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

public class Client {
	private String nom;
    private String prenom;
    private int info_carte_credit;

	
    public Client() {

    }


    public Client(String nom, String prenom, int info_carte_credit) {
        this.nom = nom;
        this.prenom = prenom;
        this.info_carte_credit = info_carte_credit;
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

    public int getInfo_carte_credit() {
        return info_carte_credit;
    }

    public void setInfo_carte_credit(int info_carte_credit) {
        this.info_carte_credit = info_carte_credit;
    }

}
