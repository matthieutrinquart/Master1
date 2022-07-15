package Common;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface dossiersuivi extends Remote{
	
	String get_suivi()throws RemoteException;
	void set_suivi(String suivi)throws RemoteException;
	

}
