package models;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;









@Entity
public class Hotel {
	@Id
	private long id_hotel;
	@Column(name = "NOM")
	private String nom;
	@Column(name = "PRIX")
	private float prix ;
	@Column(name = "NOMBRE_ETOILE")
	private int nombre_etoile;
	
	
    @OneToOne
    @JoinColumn(name="id_adresse")
    private Adresse adresse;
    
    
    
	@OneToMany(mappedBy = "hotel", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Chambre> chambre;
	
	@OneToMany(mappedBy = "hotel", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Partenaire> List_partenaire;
	
	
	public Hotel() {
	}
	
	public Hotel(long id,String nom, float prix, int nombre_etoile , Adresse adresse) {
		this.id_hotel = id;
		this.nom = nom;
		this.prix = prix;
		this.nombre_etoile = nombre_etoile;
		this.adresse = adresse;
	}

	public long getId_hotel() {
		return id_hotel;
	}

	public void setId_hotel(long id_hotel) {
		this.id_hotel = id_hotel;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public float getPrix(int id_agence , float reduction) {
    	for(Partenaire r: List_partenaire) {
    		
    		if(r.getId_partenaire() == id_agence ) {
    			
    			return (float)(this.prix)-(this.prix * reduction);
    		}
    		
    		
    	}
		return prix;
	}

	public void setPrix(float prix) {
		this.prix = prix;
	}

	public int getNombre_etoile() {
		return nombre_etoile;
	}

	public void setNombre_etoile(int nombre_etoile) {
		this.nombre_etoile = nombre_etoile;
	}

	public List<Chambre> getChambre() {
		return chambre;
	}

	public void setChambre(List<Chambre> chambre) {
		this.chambre = chambre;
	}
	
	
	
	
	
	
	
	
	
	
	
	public Adresse getAdresse() {
		return adresse;
	}

	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}


	public ArrayList<Chambre> can_res_chambre(Date a, Date b) {
		ArrayList<Chambre> tampon = new ArrayList<>();
		for (Chambre c : chambre)
			if(c.can_res(a,b)){
				tampon.add(c);
			}
			return tampon;
	}
	
	
	
	
	

	@Override
	public int hashCode() {
		return Objects.hash(List_partenaire, chambre, id_hotel, nom, nombre_etoile, prix);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Hotel other = (Hotel) obj;
		return Objects.equals(List_partenaire, other.List_partenaire) && Objects.equals(chambre, other.chambre)
				&& id_hotel == other.id_hotel && Objects.equals(nom, other.nom) && nombre_etoile == other.nombre_etoile
				&& Float.floatToIntBits(prix) == Float.floatToIntBits(other.prix);
	}

	public List<Partenaire> getList_partenaire() {
		return List_partenaire;
	}

	public void setList_partenaire(List<Partenaire> list_partenaire) {
		List_partenaire = list_partenaire;
	}

	@Override
	public String toString() {
		return "Hotel [id_hotel=" + id_hotel + ", nom=" + nom + ", prix=" + prix + ", nombre_etoile=" + nombre_etoile
				+ ", chambre=" + chambre + ", List_partenaire=" + List_partenaire + "]";
	}

	
	
	




	
	
	
	
	

}
