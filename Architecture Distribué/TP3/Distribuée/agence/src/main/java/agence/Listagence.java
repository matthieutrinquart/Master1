package agence;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;

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
	
	
	public ArrayList<Offre> lookup(int id,Date date_arrivee, Date date_depart, int nb_personne) throws ParseException {
			return this.t.get(id).lookup(date_arrivee, date_depart, nb_personne);
	}
	
	public boolean Reserver(int id_agence,Date date_arrivee , Date date_depart, int nb_personne , int id_hotel , int numero_chambre,String nom,String prenom,int infocarte) {
		return t.get(id_agence).Reserver(date_arrivee, date_depart, nb_personne, id_hotel, numero_chambre,nom,prenom,infocarte);
	}
	
    
    
    

}
