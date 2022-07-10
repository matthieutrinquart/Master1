package Models;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import javax.imageio.ImageIO;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;



public class Chambre {
    private long numero;
    private int nb_lit;
	
    private List<Reservation> List_reservation;
	private Hotel hotel;
	
	

	public Chambre() {

	}


	public Chambre(long numero, int nb_lit) throws IOException {
		this.numero = numero;
		this.nb_lit = nb_lit;
	}


	public long getNumero() {
		return numero;
	}


	public void setNumero(long numero) {
		this.numero = numero;
	}


	public int getNb_lit() {
		return nb_lit;
	}


	public void setNb_lit(int nb_lit) {
		this.nb_lit = nb_lit;
	}


	public Hotel getHotel() {
		return hotel;
	}


	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}
	
	
	


	public List<Reservation> getList_reservation() {
		return List_reservation;
	}


	public void setList_reservation(List<Reservation> list_reservation) {
		List_reservation = list_reservation;
	}



	@Override
	public int hashCode() {
		return Objects.hash(List_reservation, hotel, nb_lit, numero);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Chambre other = (Chambre) obj;
		return Objects.equals(List_reservation, other.List_reservation) && Objects.equals(hotel, other.hotel)
				&& nb_lit == other.nb_lit && numero == other.numero;
	}


	@Override
	public String toString() {
		return "Chambre [numero=" + numero + ", nb_lit=" + nb_lit + ", List_reservation="
				+ List_reservation + "]";
	}

}
