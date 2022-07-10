package Models;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.web.client.RestTemplate;

public class Comparateur {
	
	ArrayList<String> listAgence;
	
	public Comparateur() {
		
	}
	
	public Comparateur(ArrayList<String> listAgence) {
		this.listAgence = listAgence;
		
		
	}
	
	
	//ville
	//d'hébergement, dates début et fin de la réservation, nombre de personnes à héberger et le
	//type d'hôtel (nombre minimum d'étoiles). 
	public ArrayList<Offre> Lookup(String ville , Date debut , Date fin,int nb_personne,int nb_etoile ,RestTemplate proxy) {
		

    	ArrayList<Offre> list_offre = new ArrayList<>(); 
     	for(String url : listAgence) {
			Map<String,String> params = new HashMap<>();
	    	 String uri = url + "/agence/Lookup/ville={ville}from={date},to={date1},beds={lits},stars={nb_etoile}";
	 		DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");      
	    	 params.put("ville", ville);
	    	 params.put("date",dateFormat.format(debut));
	    	 params.put("date1",dateFormat.format(fin));
	    	 params.put("lits", String.valueOf(nb_personne));
	    	 params.put("nb_etoile", String.valueOf(nb_etoile));
	
	    	 
	    	
	    	 Offre[] returnH = proxy.getForObject(uri, Offre[].class,params);
	    	 
	    	 
	    	 
	    	 for(Offre o : returnH) {

	    		 list_offre.add(o);
	    	 }
    	 
  
		
    	 }

    		return list_offre;
    	}

		

}
