package server;


import Client.Notifiable;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class server extends UnicastRemoteObject  {

	public server() throws RemoteException {
		super();
	}


	public void serv(){
		try {

			System.setProperty("java.rmi.server.codebase","file:/Users/33616/IdeaProjects/TP1distri/out/production/TP1distri/Common");
			System.setProperty("java.security.policy", "file:/Users/33616/IdeaProjects/TP1distri/src/server/Server.policy");
			System.setSecurityManager(new SecurityManager());



			//exo1
			dossiersuiviImpl dossier1 = new dossiersuiviImpl("diabete");
			animalImp animal1 = new animalImp("kuma" , "matthieu","chat","européen" , 16, dossier1);


			//exo2
			dossiersuiviImpl test1 = new dossiersuiviImpl("doit prendre ces cachet");
			animalImp obj1 = new animalImp("felix" , "bernard","chat","européen" ,6, test1);

			dossiersuiviImpl test2 = new dossiersuiviImpl("doit ce reposer");
			animalImp obj2 = new animalImp("franklin" , "dupont","tortue","terre" , 8,test2);

			dossiersuiviImpl test3 = new dossiersuiviImpl("doit plus manger");
			animalImp obj3 = new animalImp("roky" , "durant","chien","labrador" , 2,test3);

			dossiersuiviImpl test4 = new dossiersuiviImpl("doit maigrir");
			animalImp obj4 = new animalImp("sunny" , "lea","lapin","européen" , 1,test4);

			CabinetVeterinaireImp cab = new CabinetVeterinaireImp();
			cab.add_animal(obj1);
			cab.add_animal(obj2);
			cab.add_animal(obj3);
			cab.add_animal(obj4);






			Registry registry = LocateRegistry.createRegistry(1099);
			//Registry registry = LocateRegistry.getRegistry();
			if (registry==null){
				System.err.println("RmiRegistry not found");
			}else{
				System.err.println("Server ready");
				registry.rebind("exo1", animal1);
				registry.rebind("exo2", cab);
			}
		} catch (Exception e) {
			System.err.println("Server exception: " + e.toString());
			e.printStackTrace();
		}


	}


	public static void main(String args[]) throws RemoteException {
		server s = new server();
		s.serv();


	}

}
