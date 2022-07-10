package Models;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;

import org.springframework.web.client.RestTemplate;

public class Listagence {
	private ArrayList<Agence> t ;

	public Listagence(ArrayList<Agence> t) {
		this.t = t;
	}
    public ArrayList<Agence>  getListagence(){
    	return t;
    }
	
	public void add_hotel(int id_agence, String url) {
		
		t.get(id_agence).add_hotel(url);
			
		
		
	};
	
	
	public ArrayList<Offre> lookup(int id,Date date_arrivee, Date date_depart, int nb_personne, String mdp,RestTemplate proxy) throws ParseException, IOException {
			return this.t.get(id).Lookup((long) id,date_arrivee,date_depart, nb_personne,  t.get(id).getId_agence(),t.get(id).getReduction(),mdp ,proxy);
	}
	
	public NewReservation Reserver(int id_agence,Date date_arrivee , Date date_depart, int nb_personne , int id_hotel , int numero_chambre,String nom,String prenom,int infocarte,String login  ,String mdp ,RestTemplate proxy) throws IOException {
		return t.get(id_agence).Reserver(date_arrivee, date_depart, nb_personne, id_hotel, numero_chambre,nom,prenom,infocarte, login, mdp ,proxy);
	}
	
    
    
    

}
