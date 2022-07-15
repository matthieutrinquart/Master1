package Common;


import java.rmi.Remote;
import java.rmi.RemoteException;

public interface animal extends Remote {
	
	String get_nom_animal()throws RemoteException;
	String get_nm_du_maitre()throws RemoteException;
	String get_race()throws RemoteException;
	String get_espece()throws RemoteException;
	int get_age() throws RemoteException;
	dossiersuivi get_dossier()throws RemoteException; 
	void set_dossier(String suivi)throws RemoteException ;
	void setNom_animal(String nom_animal) throws RemoteException ;
	void setNom_maitre(String nom_maitre)throws RemoteException ;






}
