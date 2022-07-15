package server;

import Common.animal;
import Common.dossiersuivi;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class animalImp extends UnicastRemoteObject  implements animal {
	private String nom_animal;
	private Espece esp;
	private String nom_maitre;
	private dossiersuiviImpl dossier_animal;
	
	
	
	public animalImp(String nom_animal, String nom_maitre, String nom_espece, String nom_race, int _age, dossiersuiviImpl dossier_animal) throws RemoteException {
		super();
		this.nom_animal = nom_animal;
		
		this.nom_maitre = nom_maitre;

		this.esp = new Espece(nom_espece,nom_race,_age);

		this.dossier_animal = dossier_animal;
		
		// TODO Auto-generated constructor stub
	}
	
	public String get_nm_du_maitre()throws RemoteException{
		// TODO Auto-generated method stub
		return nom_maitre;
	}

	public String get_race()throws RemoteException {
		// TODO Auto-generated method stub
		return esp.getRace();
	}

	public String get_espece() throws RemoteException{
		// TODO Auto-generated method stub
		return esp.getSpeciesName();
	}

	public int get_age() throws RemoteException{
		// TODO Auto-generated method stub
		return esp.getSpeciesAverageLife();
	}


	public String get_nom_animal() throws RemoteException{
		// TODO Auto-generated method stub
		return nom_animal;
	}

	public dossiersuivi get_dossier() throws RemoteException {
		// TODO Auto-generated method stub
		return dossier_animal;
	}
	
	public void set_dossier(String suivi)throws RemoteException {
		this.dossier_animal.set_suivi(suivi);
		
		
	}


	public void setNom_animal(String nom_animal) {
		this.nom_animal = nom_animal;
	}


	public void setNom_maitre(String nom_maitre) {
		this.nom_maitre = nom_maitre;
	}

}
