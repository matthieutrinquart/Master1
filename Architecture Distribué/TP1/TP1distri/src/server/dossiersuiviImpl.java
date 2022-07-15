package server;


import Common.dossiersuivi;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class dossiersuiviImpl extends UnicastRemoteObject  implements dossiersuivi {

	
	String suivi;
	public dossiersuiviImpl(String suivi) throws RemoteException{
		super();
		this.suivi = suivi;
		
		
		
		
	}
	public String get_suivi() throws RemoteException {
		// TODO Auto-generated method stub
		return suivi;
	}
	public void set_suivi(String suivi) throws RemoteException {
		// TODO Auto-generated method stub
		
		this.suivi = suivi;
	}
	
	

}
