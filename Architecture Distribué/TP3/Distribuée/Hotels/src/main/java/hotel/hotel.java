package hotel;

import javax.jws.WebMethod;
import javax.jws.WebMethod;
import javax.jws.WebService;
import java.util.ArrayList;
import java.util.Date;
import hotel.*;
import java.util.ArrayList;
import java.util.Date;
@WebService(endpointInterface= "hotel.Ihotel")
public class hotel implements Ihotel{
	private int id_hotel;
	private String nom;
	private adresse addr;
	private float prix ;
	private int nombre_etoile;
	private int nombre_lit=0;
	private ArrayList<chambre> list_chambre;
	private ArrayList<Partenaire> List_partenaire;

	public hotel(int id_hotel,String nom,String pays, String ville, String rue, String lieu_dit, int numero, int positionGPS, int prix, int nombre_etoile , ArrayList<chambre> list_chambre,ArrayList<Partenaire> List_partenaire) {
		this.id_hotel = id_hotel;
		this.nom = nom;
		this.addr = new adresse(pays,ville,rue,lieu_dit,numero,positionGPS);
		this.prix = prix;
		this.nombre_etoile = nombre_etoile;

		this.list_chambre = list_chambre;
		for(chambre c : this.list_chambre){
			this.nombre_lit = this.nombre_lit + c.getNb_lit();

		}
		this.List_partenaire = List_partenaire;
		
		
		
		
		
	}
	
	public int getid() {
		return this.id_hotel;
	}

	public String getNom() {
		return nom;
	}
	

	public void setNom(String nom) {
		this.nom = nom;
	}
	
	public adresse getAddr() {
		return addr;
	}

	public float getPrix(int id_agence , float reduction) {
    	for(Partenaire r: List_partenaire) {
    		
    		if(r.getId_partenaire() == id_agence ) {
    			
    			return (float)(this.prix)-(this.prix * reduction);
    		}
    		
    		
    	}
		return prix;
	}
	public int getNombre_etoile() {
		return nombre_etoile;
	}

	public int getNombre_lit() {
		return nombre_lit;
	}

	public void setAddr(adresse addr) {
		this.addr = addr;
	}

	public void setPrix(int prix) {
		this.prix = prix;
	}

	public void setNombre_etoile(int nombre_etoile) {
		this.nombre_etoile = nombre_etoile;
	}

	public void setNombre_lit(int nombre_lit) {
		this.nombre_lit = nombre_lit;
	}

	public ArrayList<chambre> getList_chambre() {
		return list_chambre;
	}

	public void setList_chambre(ArrayList<chambre> list_chambre) {
		this.list_chambre = list_chambre;
	}
	
	@Override
	public ArrayList<chambre> can_res_chambre(Date a, Date b) {
		ArrayList<chambre> tampon = new ArrayList<>();
		for (chambre c : list_chambre)
			if(c.can_res(a,b)){
				tampon.add(c);
			}
			return tampon;
	}




	public String toString() {
		return "hotel{" +
				"nom='" + nom + '\'' +
				", addr=" + addr +
				", prix=" + prix +
				", nombre_etoile=" + nombre_etoile +
				'}';
	}

	@Override
	public boolean Reserver(Date a, Date b, int nombre_personne, int numero_chambre , String nom , String prenom,int infocarte) {
		if(this.list_chambre.get(numero_chambre).can_res(a, b)) {
			client c = new client(nom,prenom,infocarte);
			reservation r = new reservation(a,b,c);
			this.list_chambre.get(numero_chambre).new_reservation(r);
			return true;
		}
		else {
			return false;
		}
	}

}
