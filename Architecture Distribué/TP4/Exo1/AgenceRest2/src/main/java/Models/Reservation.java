package Models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;


public class Reservation {

	private int id;

    private Date date_arrivee;
    private Date date_depart;
	

	private Chambre chambre;

    private Client client;
	
	
	

	 public Reservation() {
		 
		 
	 }
    public Reservation(Date date_arrivee, Date date_depart,Client client,Chambre chambre){
        this.date_arrivee = date_arrivee;
        this.date_depart = date_depart;
        this.chambre = chambre;
        this.client = client;
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
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	public Chambre getChambre() {
		return chambre;
	}
	public void setChambre(Chambre chambre) {
		this.chambre = chambre;
	}
	
	
    
    

}
