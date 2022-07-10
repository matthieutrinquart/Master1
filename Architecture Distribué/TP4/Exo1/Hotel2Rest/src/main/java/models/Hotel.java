package models;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;









@Entity
public class Hotel {
	@Id
	private long id_hotel;
	@Column(name = "NOM")
	private String nom;
	@Column(name = "PRIX")
	private float prix ;
	@Column(name = "NOMBRE_ETOILE")
	private int nombre_etoile;
	@OneToMany(mappedBy = "hotel", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Chambre> chambre;
	
	@OneToMany(mappedBy = "hotel", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Partenaire> List_partenaire;
	
	
	public Hotel() {
	}
	
	public Hotel(long id,String nom, float prix, int nombre_etoile) {
		this.id_hotel = id;
		this.nom = nom;
		this.prix = prix;
		this.nombre_etoile = nombre_etoile;
		//this.chambre = chambre;
		//this.List_partenaire = List_partenaire;
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

	public float getPrix(int id_agence , float reduction) {
    	for(Partenaire r: List_partenaire) {
    		
    		if(r.getId_partenaire() == id_agence ) {
    			
    			return (float)(this.prix)-(this.prix * reduction);
    		}
    		
    		
    	}
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

	public List<Chambre> getChambre() {
		return chambre;
	}

	public void setChambre(List<Chambre> chambre) {
		this.chambre = chambre;
	}
	
	public boolean Reserver(Date a, Date b, int nombre_personne, int numero_chambre , String nom , String prenom,int infocarte) {
		if(this.chambre.get(numero_chambre).can_res(a, b)) {
			Client c = new Client(nom,prenom,infocarte);
			Reservation r = new Reservation(a,b,c,this.chambre.get(numero_chambre));
			return true;
		}
		else {
			return false;
		}
	}
    public ArrayList<Disponibiliter> date_disponible(Chambre c) throws ParseException {
    	DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy"); 
    	List<Reservation> test = c.getList_reservation();
        ArrayList<Disponibiliter> r = new ArrayList<>();
        SimpleDateFormat format1 = new SimpleDateFormat("dd/MM/yyyy");
       	Date date_min= format1.parse("01/01/0000");
       	Date date_max= format1.parse("31/12/9999");
        if(!c.getList_reservation().isEmpty()) {
        for(int i = 0 ; i < test.size() -2 ;++i) {
        	
        	int min =i;
        	for(int j = i+1 ; j < test.size() -1 ;++j) {
        		if(test.get(j).getDate_arrivee().compareTo(test.get(min).getDate_arrivee()) <0) {
        			
        			min = j;
        		}
        	}
        	if(min != i) {
        		Reservation s = test.get(i);
        		test.set(i,  test.get(min)) ;
        		test.set(min,  s) ;    		
        	}	

    	}


        

	        Date dated = test.get(0).getDate_arrivee();
	        Calendar f = Calendar.getInstance();
	        f.setTime(dated);
	        f.add(Calendar.DATE, -1);
	        dated.setTime( f.getTime().getTime() );
	    	dateFormat.format(date_min);
	        Disponibiliter d = new Disponibiliter(dateFormat.format(date_min) ,dateFormat.format(dated));
	        r.add(d);
	        for(int i = 1 ; i < test.size() ; ++i) {
	            
	            Date date1 = test.get(i-1).getDate_depart();
	            Calendar f1 = Calendar.getInstance();
	            f1.setTime(date1);
	            f1.add(Calendar.DATE, 1);
	            date1.setTime( f1.getTime().getTime() );
	            
	            
	           
	            
	            Date date2 = test.get(i).getDate_arrivee();
	            Calendar f2 = Calendar.getInstance();
	            f2.setTime(date2);
	           // f2.add(Calendar.DATE, -1);
	            date2.setTime( f2.getTime().getTime() );  
	            
	            //System.out.println(date1 + "     " + date2);
	            
	            r.add(new Disponibiliter(dateFormat.format(date2) ,dateFormat.format(date1)));
	        }
	        
	        Date datefin = test.get(test.size()-1).getDate_depart();
	        Calendar f1 = Calendar.getInstance();
	        f1.setTime(datefin);
	        f1.add(Calendar.DATE, 1);
	        datefin.setTime( f1.getTime().getTime() );
	    	
	        
	        r.add(new Disponibiliter( dateFormat.format(datefin), dateFormat.format(date_max)));	
        }
        else {
        
            r.add(new Disponibiliter(dateFormat.format(date_min),dateFormat.format(date_max)));	
        }
        
        return r;
        
       
    	
    	
    	
    }
	public ArrayList<Chambre> can_res_chambre(Date a, Date b) {
		ArrayList<Chambre> tampon = new ArrayList<>();
		for (Chambre c : chambre)
			if(c.can_res(a,b)){
				tampon.add(c);
			}
			return tampon;
	}
	
	
	
	
	

	@Override
	public int hashCode() {
		return Objects.hash(List_partenaire, chambre, id_hotel, nom, nombre_etoile, prix);
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
		return Objects.equals(List_partenaire, other.List_partenaire) && Objects.equals(chambre, other.chambre)
				&& id_hotel == other.id_hotel && Objects.equals(nom, other.nom) && nombre_etoile == other.nombre_etoile
				&& Float.floatToIntBits(prix) == Float.floatToIntBits(other.prix);
	}

	public List<Partenaire> getList_partenaire() {
		return List_partenaire;
	}

	public void setList_partenaire(List<Partenaire> list_partenaire) {
		List_partenaire = list_partenaire;
	}

	@Override
	public String toString() {
		return "Hotel [id_hotel=" + id_hotel + ", nom=" + nom + ", prix=" + prix + ", nombre_etoile=" + nombre_etoile
				+ ", chambre=" + chambre + ", List_partenaire=" + List_partenaire + "]";
	}

	
	
	




	
	
	
	
	

}
