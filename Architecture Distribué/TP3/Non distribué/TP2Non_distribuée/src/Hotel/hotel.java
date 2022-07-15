package Hotel;


import client.Date;
import client.reservation;

import java.util.ArrayList;


public class hotel {

	private String nom;
	private int id;
	private adresse addr;
	private int prix ;
	private int nombre_etoile;
	private int nombre_lit=0;
	private ArrayList<chambre> list_chambre;


	public hotel(int id,String nom,String pays, String ville, String rue, String lieu_dit, int numero, int positionGPS, int prix, int nombre_etoile , ArrayList<chambre> list_chambre) {
		this.nom = nom;
		this.id = id;
		this.addr = new adresse(pays,ville,rue,lieu_dit,numero,positionGPS);
		this.prix = prix;
		this.nombre_etoile = nombre_etoile;

		this.list_chambre = list_chambre;
		for(chambre c : this.list_chambre){
			this.nombre_lit = this.nombre_lit + c.getNb_lit();

		}
	}

	public String getNom() {
		return nom;
	}



	public int getId() {
		return id;
	}

	public adresse getAddr() {
		return addr;
	}

	public int getPrix() {
		return prix;
	}

	public int getNombre_etoile() {
		return nombre_etoile;
	}

	public boolean reservation(reservation r , int id_chambre){
		if(list_chambre.get(id_chambre).can_res(r.getDate_arrivee(),r.getDate_depart())){

			list_chambre.get(id_chambre).new_reservation(r);
			return true;
		}
		else{
			return false;
		}



	}


	public ArrayList<chambre> getList_chambre() {
		return list_chambre;
	}


	@Override
	public String toString() {
		return "hotel{" +
				"nom='" + nom + '\'' +
				"\n addr=" + addr.toString() +
				"\n, prix=" + prix +
				", nombre_etoile=" + nombre_etoile +
				'}';
	}
}
