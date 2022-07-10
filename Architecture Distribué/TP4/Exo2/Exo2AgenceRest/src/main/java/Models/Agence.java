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

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.client.RestTemplate;





@Entity
public class Agence {
	@Id
	private long id_agence;
	@Column(name = "NOM_AGENCE")
	private String Nom_agence;
	@Column(name = "LOGIN")
	private String login;
	@Column(name = "MOTS_DE_PASSE")
	private String mdp;
	@Column(name = "REDUCTION")
	private float reduction;

	
	@Column(name = "LIST_HOTEL")
	@ElementCollection
    private List<String> h;
    
   
    
    public Agence() {
    	
    }

    public Agence(String Nom_agence, int id_agence , float reduction , String login , String mdp , List<String> h )  {
    	
    	this.Nom_agence = Nom_agence;
    	
    	this.id_agence = id_agence;
    	
    	this.login = login;
    	this.mdp = mdp;
    	
    	
    	this.reduction = reduction;
    	this.h = h;
    	
    	
        
        
    }
    
    
    
    
    

    public long getId_agence() {
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
    

	public List<String> getH() {
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
	

    public ArrayList<Offre> Lookup(String ville,String date, String date1,  int lits,  int id_partenaire,  float pourcentage_reduc,int nb_etoile ,RestTemplate proxy) throws IOException{


    	//String uri = h.get(id_hotel);
    	// uri = uri +"/1/Reservation";
    	ArrayList<Offre> list_offre = new ArrayList<>(); 
     	for(String url : h) {
			Map<String,String> params = new HashMap<>();
	    	 String uri = url + "/Lookup/from={date},to={date1},beds={lits},partenaire={id_partenaire},reduction={pourcentage_reduc}";
	 		//DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");      
	    	 params.put("date",date);
	    	 params.put("date1",date1);
	    	 params.put("lits", String.valueOf(lits));
	    	 params.put("id_partenaire", String.valueOf(id_partenaire));
	    	 params.put("pourcentage_reduc", String.valueOf(pourcentage_reduc));
	
	    	 
	    	
	    	 Offre[] returnH = proxy.getForObject(uri, Offre[].class,params);
	    	 
	    	 
	    	 
	    	 for(Offre o : returnH) {
	    		 System.out.println(o.getAdr().getVille());
	    		 if( o.getNb_etoile() >= nb_etoile && o.getAdr().getVille().equals(ville)) {
	    			 o.setNom_agence(this.getNom_agence());
		    		 list_offre.add(o);
	    			 
	    			 
	    		 }
	    	 }
    	 
  
		
    	 }

    		return list_offre;
    		}
    
    
    
}
