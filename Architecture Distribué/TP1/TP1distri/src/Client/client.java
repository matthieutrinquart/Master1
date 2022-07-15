package Client;


import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

import Common.*;

public class client extends UnicastRemoteObject implements Notifiable{

	animal an = null;

	CabinetVeterinaire cab = null;
	public client() throws RemoteException {
		super();
	}

	@Override
	public void notify(String msg) throws RemoteException {
		System.out.println("Notif : " + msg);
	}

		public void cl(String[] args) {

			String host = (args.length < 1) ? null : args[0];
			try {

				Registry registry = LocateRegistry.getRegistry(host);

				//exo1
				an = (animal) registry.lookup("exo1");
				System.out.println("nom_animal: " + an.get_nom_animal());
				System.out.println("nom espèce: " + an.get_espece());
				System.out.println("nom maitre: " + an.get_nm_du_maitre());
				System.out.println("Age : " + an.get_age());
				System.out.println("race: " + an.get_race());
				System.out.println("dossier: " + an.get_dossier().get_suivi());

				System.out.println("\n\n\n");

				an.set_dossier("guérie");
				System.out.println("dossier: " + an.get_dossier().get_suivi());
				System.out.println("\n\n\n");


				//exo2
				cab = (CabinetVeterinaire) registry.lookup("exo2");
				cab.add_veterinaire(this);
				animal patient = cab.get_animal("sunny");
				System.out.println("nom_animal: " + patient.get_nom_animal());
				System.out.println("nom espèce: " + patient.get_espece());
				System.out.println("nom maitre: " + patient.get_nm_du_maitre());
				System.out.println("race: " + patient.get_race());
				System.out.println("dossier: " + patient.get_dossier().get_suivi());
				cab.new_animal("rober","julien","hamster","europeen",5,"doit courir");

				System.out.println("\n\n\n");
				animal patient2 = cab.get_animal("rober");
				System.out.println("nom_animal: " + patient2.get_nom_animal());
				System.out.println("nom espèce: " + patient2.get_espece());
				System.out.println("nom maitre: " + patient2.get_nm_du_maitre());
				System.out.println("race: " + patient2.get_race());
				System.out.println("dossier: " + patient2.get_dossier().get_suivi());

				System.out.println("\n\n\n");



				//exo3 et 5
				for (int i = 0 ; i< 100 ; ++i) {
					cab.new_animal("rober", "julien", "hamster", "europeen", 10, "doit courir");
				}

				System.out.println("\n\n\n");

				for (int i = 0 ; i< 400 ; ++i) {
					cab.new_animal("rober", "julien", "hamster", "europeen", 10, "doit courir");
				}

				System.out.println("\n\n\n");

				for (int i = 0 ; i< 500 ; ++i) {
					cab.new_animal("rober", "julien", "hamster", "europeen", 10, "doit courir");
				}

				System.out.println("\n\n\n");



			} catch (Exception e) {
				System.err.println("Client exception: " + e.toString());
				e.printStackTrace();
			}
		}

	public static void main(String[] args) throws RemoteException {
		client c = new client();
		c.cl(args);
	}


	
	

}
