package models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class Reservation {
	
	
	@Id
	@GeneratedValue
	private int id;
	//private client c;
	@Column(name = "DATE_ARRIVEE")
    private Date date_arrivee;
	@Column(name = "DATE_DEPART")
    private Date date_depart;
	
	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="chambre_id", nullable=false)
	private Chambre chambre;
	

	
	

	 public Reservation() {
		 
		 
	 }
    public Reservation(Date date_arrivee, Date date_depart,Chambre chambre){//,client c  ) {
        this.date_arrivee = date_arrivee;
        this.date_depart = date_depart;
        this.chambre = chambre;
    }


    public Date getDate_arrivee() {
        return date_arrivee;
    }

    public void setDate_arrivee(Date date_arrivee) {
        this.date_arrivee = date_arrivee;
    }

    public Date getDate_depart() {
        return date_depart;
    }

    public void setDate_depart(Date date_depart) {
        this.date_depart = date_depart;
    }
	public Chambre getChambre() {
		return chambre;
	}
	public void setChambre(Chambre chambre) {
		this.chambre = chambre;
	}
    
    
    



}
