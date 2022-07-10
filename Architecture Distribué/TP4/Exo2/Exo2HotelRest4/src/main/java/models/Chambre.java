package models;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import javax.imageio.ImageIO;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;





@Entity
public class Chambre {
	
	@Id
	@GeneratedValue
	private long id_chambre;
	
	
	@Column(name = "NUMERO")
    private long numero;
	@Column(name = "NOMBRE_DE_LIT")
    private int nb_lit;
	
	//@Column(name = "IMAGE")
  //  private byte[] pic_bytes = new byte[500000];
	@OneToMany(mappedBy = "chambre", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Reservation> List_reservation;
	

	
	
	
	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="hotel_id_hotel", nullable=false)
	private Hotel hotel;
	
	
	
	@Column(name = "Adresse_Image")
	private String image;

	public Chambre() {

	}


	public Chambre(long numero, int nb_lit,String image, Hotel hotel) throws IOException {
		this.numero = numero;
		this.nb_lit = nb_lit;
		this.hotel = hotel;
		this.image = image;
		

   
	}


	public long getId_chambre() {
		return id_chambre;
	}


	public void setId_chambre(long id_chambre) {
		this.id_chambre = id_chambre;
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
	
	
	
	
	
	
	
    public String getImage() {
		return image;
	}


	public void setImage(String image) {
		this.image = image;
	}


	public boolean can_res(Date a , Date b ){
        boolean tamp = true;

        for (Reservation r : List_reservation){
            if(((a.before(r.getDate_depart())) ) && a.after(r.getDate_arrivee()) || (b.before(r.getDate_depart())  && b.after(r.getDate_arrivee())) || ((r.getDate_depart().after(a) ) && r.getDate_depart().before(b)) || (r.getDate_arrivee().after(a)  && r.getDate_arrivee().before(b))
            		|| r.getDate_arrivee().equals(a) ||  r.getDate_arrivee().equals(b) || r.getDate_depart().equals(a)|| r.getDate_depart().equals(b)){

                tamp = false;
            }
        }
        return tamp;

    }


	@Override
	public int hashCode() {
		return Objects.hash(List_reservation, hotel, id_chambre, nb_lit, numero);
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
				&& id_chambre == other.id_chambre && nb_lit == other.nb_lit && numero == other.numero;
	}


	@Override
	public String toString() {
		return "Chambre [id_chambre=" + id_chambre + ", numero=" + numero + ", nb_lit=" + nb_lit + ", List_reservation="
				+ List_reservation + "]";
	}
	
	

	
	
	

}
