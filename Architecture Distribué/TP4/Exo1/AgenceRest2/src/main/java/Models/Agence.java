package Models;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.client.RestTemplate;






public class Agence {
private String Nom_agence;
	
	private int id_agence;
	
	private String login;
	
	private String mdp;
	
	private float reduction;

	
	
    private ArrayList<String> h;
    
    
   //private ArrayList<HotelRepository> hotelPartenaire;
    
    public Agence() {
    	
    }

    public Agence(String Nom_agence, int id_agence , float reduction , String login , String mdp)  {
    	
    	this.Nom_agence = Nom_agence;
    	
    	this.id_agence = id_agence;
    	
    	this.login = login;
    	this.mdp = mdp;
    	
    	
    	this.reduction = reduction;
    	this.h = new ArrayList<>();
    	
    	
        
        
    }
    
    
    
    
    

    public int getId_agence() {
		return id_agence;
	}

	public void setId_agence(int id_agence) {
		this.id_agence = id_agence;
	}

	public String getLogin() {
		return login;
	}



	public void setLogin(String login) {
		this.login = login;
	}



	public String getMdp() {
		return mdp;
	}



	public void setMdp(String mdp) {
		this.mdp = mdp;
	}



	public String getNom_agence() {
		return Nom_agence;
	}
    

	public ArrayList<String> getH() {
		return h;
	}
	
	

	public float getReduction() {
		return reduction;
	}



	public void setReduction(float reduction) {
		this.reduction = reduction;
	}



	public void setH(ArrayList<String> h) {
		this.h = h;
	}

	public void setNom_agence(String nom_agence) {
		Nom_agence = nom_agence;
	}
	
	
	public void add_hotel(String a){
		
    	h.add(a);

        
    }
	
	
    public NewReservation Reserver(Date date_arrivee , Date date_depart, int nb_personne , int id_hotel , int numero_chambre,String nom,String prenom,int infocarte,String Login,String mdp ,RestTemplate proxy) throws IOException{


    	if(this.login.equals(Login)) {
	    		if(this.mdp.equals(mdp)) {
	
	 
	    		String uri = h.get(id_hotel) + "/Reservation";
	    	 Chambre ch1 = new Chambre(numero_chambre,nb_personne);
	    	 Client cl1 = new Client(nom,prenom,infocarte);
	    	 Reservation res =new Reservation(date_arrivee,date_depart,cl1,ch1);
	
	
	    	 
	    	NewReservation nw = new NewReservation(res , ch1);
	    	
	    	NewReservation returnH = proxy.postForObject(uri,nw,NewReservation.class);
			//System.out.println(String.format("Succesfully added Hotel %s ;",returnH));
	    	if(returnH == null) {
	    		System.out.println("Problèmes dans la Reservation");
	    		return null;
	    	}
	    	else
	    		return returnH;
	    	}
	    	else {
	    		System.out.println("PROBLEME DE MDP");
	    		return null;
	    			
	    			
	    		}
    	}
    	else {
    		
    		
    		System.out.println("PROBLEME DE LOGIN");
    		return null;
    	}
    	
   
    	
    }
    public ArrayList<Offre> Lookup(long id,Date date, Date date1,  int lits,  int id_partenaire,  float pourcentage_reduc,String mdp ,RestTemplate proxy) throws IOException{


    	//String uri = h.get(id_hotel);
    	// uri = uri +"/1/Reservation";
    	if(mdp.equals(this.mdp)) {
    	ArrayList<Offre> list_offre = new ArrayList<>(); 
     	for(String url : h) {
			Map<String,String> params = new HashMap<>();
	    	 String uri = url + "/Lookup/from={date},to={date1},beds={lits},partenaire={id_partenaire},reduction={pourcentage_reduc}";
	 		DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");      
	    	 params.put("date",dateFormat.format(date));
	    	 params.put("date1",dateFormat.format(date1));
	    	 params.put("lits", String.valueOf(lits));
	    	 params.put("id_partenaire", String.valueOf(id_partenaire));
	    	 params.put("pourcentage_reduc", String.valueOf(pourcentage_reduc));
	
	    	 
	    	
	    	 Offre[] returnH = proxy.getForObject(uri, Offre[].class,params);
	    	 
	    	 
	    	 
	    	 for(Offre o : returnH) {

	    		 list_offre.add(o);
	    	 }
    	 
  
		
    	 }

    		return list_offre;
    	}
    	else {
    		
    		
    		System.out.println("ERREUR DE MOTS DE PASSE");
    		return null;
    	}
    	
   
    	
    }
     	
	
}
