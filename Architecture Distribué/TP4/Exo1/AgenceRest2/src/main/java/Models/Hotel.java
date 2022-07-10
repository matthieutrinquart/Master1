package Models;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Hotel {
	

	private long id_hotel;
	private String nom;
	private float prix ;
	private int nombre_etoile;
	
	public Hotel() {
		
	}

	public Hotel(String nom, float prix, int nombre_etoile) {
		this.nom = nom;
		this.prix = prix;
		this.nombre_etoile = nombre_etoile;
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

	public float getPrix() {
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

	@Override
	public int hashCode() {
		return Objects.hash(id_hotel, nom, nombre_etoile, prix);
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
		return id_hotel == other.id_hotel && Objects.equals(nom, other.nom) && nombre_etoile == other.nombre_etoile
				&& Float.floatToIntBits(prix) == Float.floatToIntBits(other.prix);
	}

	@Override
	public String toString() {
		return "Hotel [id_hotel=" + id_hotel + ", nom=" + nom + ", prix=" + prix + ", nombre_etoile=" + nombre_etoile
				+ "]";
	}
	
	
	
	
	
	
	
	

}
