package models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Partenaire {
	
	@Id
	@GeneratedValue
	private int id;
	@Column(name = "NOM_PARTENAIRE")
	private String Nom_partenaire;
	@Column(name = "ID_PARTENAIRE")
	private int id_partenaire;
	
	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="hotel_id_hotel", nullable=false)
	private Hotel hotel;
	public Partenaire() {
	}
	
	
	
	public Partenaire(String nom_partenaire, int id_part , Hotel hotel) {
		Nom_partenaire = nom_partenaire;
		this.id_partenaire = id_part;
		this.hotel = hotel;
	}
	public String getNom_partenaire() {
		return Nom_partenaire;
	}
	public void setNom_partenaire(String nom_partenaire) {
		Nom_partenaire = nom_partenaire;
	}
	public int getId_partenaire() {
		return id_partenaire;
	}
	public void setId_partenaire(int id_part) {
		this.id_partenaire = id_part;
	}

}
