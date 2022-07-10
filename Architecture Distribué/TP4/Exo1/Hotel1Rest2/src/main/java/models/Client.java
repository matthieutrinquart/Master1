package models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
@Entity
public class Client {
	
		@Id
		@GeneratedValue
		private long id_client;
		
		@Column(name = "NOM")
		private String nom;
		@Column(name = "Prenom")
	    private String prenom;
		@Column(name = "Carte_credit")
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
