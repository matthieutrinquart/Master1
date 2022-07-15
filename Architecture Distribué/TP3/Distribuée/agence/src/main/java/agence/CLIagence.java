package agence;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

import javax.imageio.ImageIO;

import proxy.Chambre;
import proxy.Ihotel;
import proxy.Reservation;
public class CLIagence {
	public static final String QUIT = "0";
	public static  Listagence r = null;
	public static void main(String[] args) throws ParseException {
		CLIagence main = new CLIagence();
    	ArrayList<Agence> t = new ArrayList<>();
    	t.add(new Agence("agence du plaisir",0,(float)0.25,"login1","mdp1"));
    	t.add(new Agence("agence du bonheur",1,(float)0.5,"login2","mdp2"));
    	t.add(new Agence("agence",2,(float)0.75,"login3","mdp3"));
    	
    	t.add(new Agence("agence Paris",3,(float)0.3,"login4","mdp4"));
    	t.add(new Agence("agence Marseille",4,(float)0.7,"login5","mdp5"));
    	t.add(new Agence("agence Renne",5,(float)0.9,"login6","mdp6"));
    	

		r = new Listagence(t);
		r.add_hotel(0, "http://localhost:1111/HotelRepository1?wsdl");
		r.add_hotel(0, "http://localhost:2222/HotelRepository2?wsdl");
		r.add_hotel(0, "http://localhost:4444/HotelRepository4?wsdl");
		

		r.add_hotel(1, "http://localhost:3333/HotelRepository3?wsdl");
		r.add_hotel(1, "http://localhost:4444/HotelRepository4?wsdl");
		r.add_hotel(1, "http://localhost:5555/HotelRepository5?wsdl");
		
		r.add_hotel(2, "http://localhost:1111/HotelRepository1?wsdl");
		r.add_hotel(2, "http://localhost:2222/HotelRepository2?wsdl");
		r.add_hotel(2, "http://localhost:4444/HotelRepository4?wsdl");
		
		
		r.add_hotel(3, "http://localhost:1111/HotelRepository1?wsdl");
		r.add_hotel(3, "http://localhost:4444/HotelRepository4?wsdl");
		r.add_hotel(3, "http://localhost:5555/HotelRepository5?wsdl");
		

		r.add_hotel(4, "http://localhost:2222/HotelRepository2?wsdl");
		r.add_hotel(4, "http://localhost:3333/HotelRepository3?wsdl");
		r.add_hotel(4, "http://localhost:4444/HotelRepository4?wsdl");

		
		r.add_hotel(5, "http://localhost:1111/HotelRepository1?wsdl");
		r.add_hotel(5, "http://localhost:2222/HotelRepository2?wsdl");
		r.add_hotel(5, "http://localhost:3333/HotelRepository3?wsdl");



		BufferedReader inputReader;
		String userInput = "";
		try {
			inputReader = new BufferedReader(
					new InputStreamReader(System.in));

			do {
				main.menu();
				userInput = inputReader.readLine();
				main.processUserInput( userInput);
				Thread.sleep(3000);
			} while(!userInput.equals(QUIT));
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}


	protected void menu() {
	StringBuilder builder = new StringBuilder();
	builder.append(QUIT+". Quit.");
	builder.append("\n1. Chercher des offres");
	builder.append("\n2. Reserver");
	builder.append("\n3. afficher tous les offres de toutes les agences");
	System.out.println(builder);
	}
		
	private void processUserInput(String userInput) throws IOException, ParseException {
		switch(userInput) {
		case "1":
			Scanner sc = new Scanner(System.in);
			System.out.println("Identifiant agence :");
			int id = sc.nextInt();
			sc.nextLine();
			
			
			System.out.println("Mots de passe de agence :");
			String mdp = sc.nextLine();
			
			
			
			
			System.out.println("Date de début de la réservation : (dd/MM/yyyy)");
			String date_début = sc.nextLine();
			System.out.println("Date de fin de la réservation :(dd/MM/yyyy)");
			String date_fin = sc.nextLine();
			System.out.println("Nombre de personnes à heberger :");
			int nb_personne = sc.nextInt();
		    Date date_arrivé = new SimpleDateFormat("dd/MM/yyyy").parse(date_début);
		    Date date_départ = new SimpleDateFormat("dd/MM/yyyy").parse(date_fin);
			if(r.getListagence().get(id).getMdp().equals(mdp)) {
				ArrayList<Offre> l = r.lookup(id, date_arrivé, date_départ, nb_personne);
		    	for(int j = 0; j < l.size() ;++j) {
			    	System.out.println("id hotel : " + l.get(j).getId_offre());
			    	System.out.println("nom hotel : " + l.get(j).getNom());
			    	System.out.println("numéro chambre : " + l.get(j).getNumero_chambre());
			    	System.out.println("nombre de lits : " + l.get(j).getNb_lits());
			    	for(Disponibiliter d : l.get(j).getDisponible()) {
			    	       DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
			    	        String date1 = formatter.format(d.date1);
			    	        String date2 = formatter.format(d.date2);
			    		System.out.println("	disponible du {" + date1 + " au " + date2+ "}");
			    	}
			    	System.out.println("prix : " + l.get(j).getPrix());
			    	l.get(j).EcrireImage();
			    	System.out.println("\n");
		    	}
			}
			else {
				System.out.println("erreur dans le mots de passe");
				
			}
			
			
			break;
		case "2":
			Scanner sc1 = new Scanner(System.in);
			System.out.println("Identifiant l agence :");
			int id_agence = sc1.nextInt();
			sc1.nextLine();
			System.out.println("login de l agence :");
			String login = sc1.nextLine();
			System.out.println("mot de passe de l agence :");
			String mdp2 = sc1.nextLine();	
			System.out.println("Identifiant de l'hotel:");
			int id_hotel = sc1.nextInt();
			System.out.println("numero de la chambre:");
			int num_chambre = sc1.nextInt();
			System.out.println("nombre de personne à hebergé:");
			int nb_personne_res = sc1.nextInt();
			System.out.println("nom client");
			sc1.nextLine();	
			String nom = sc1.nextLine();	
			System.out.println("prenom client");
			String prenom = sc1.nextLine();	
			System.out.println("info carte bancaire");
			int info_carte = sc1.nextInt();
			System.out.println("Date de début de la réservation : (dd/MM/yyyy)");
			sc1.nextLine();	
			String date_début_res = sc1.nextLine();
			System.out.println("Date de fin de la réservation :(dd/MM/yyyy)");
			String date_fin_res = sc1.nextLine();
			
		    Date date_arrivé_res = new SimpleDateFormat("dd/MM/yyyy").parse(date_début_res);
		    Date date_départ_res = new SimpleDateFormat("dd/MM/yyyy").parse(date_fin_res);
		    
		    if(r.getListagence().get(id_agence).getLogin().equals(login)) {
		    
			    if(r.getListagence().get(id_agence).getMdp().equals(mdp2)) {
					if(r.Reserver(id_agence, date_arrivé_res, date_départ_res, nb_personne_res, id_hotel, num_chambre, nom, prenom, info_carte))
					{
					
						System.out.println("Reservation validée pour : ");
						
				    	System.out.println("id hotel : " + r.getListagence().get(id_agence).getH().get(id_hotel).getid());
				    	System.out.println("nom hotel : " +r.getListagence().get(id_agence).getH().get(id_hotel).getNom());
				    	System.out.println("numéro chambre : " + r.getListagence().get(id_agence).getH().get(id_hotel).getListChambre().get(num_chambre).getNumero());
				    	System.out.println("nombre de lits : " + r.getListagence().get(id_agence).getH().get(id_hotel).getListChambre().get(num_chambre).getNbLit());
				    	System.out.println("prix : " + r.getListagence().get(id_agence).getH().get(id_hotel).getPrix(id_agence, r.getListagence().get(id_agence).getReduction()));
						
					}
					else {
						System.out.println("problèmes de reservation");
					}
			    }
			    else {
			    	System.out.println("problèmes de mots de passe");
			    	
			    }
		    }
		    else {
			    
		    System.out.println("problèmes de login");
		    }
			break;
		case "3":
			for(int i = 0; i < r.getListagence().size();++i) {
				System.out.println("Nom agence : " + r.getListagence().get(i).getNom_agence());
				System.out.println("Id agence : " + r.getListagence().get(i).getId_agence());
				System.out.println("réduction agence : " + r.getListagence().get(i).getReduction());
				System.out.println("login agence : " + r.getListagence().get(i).getLogin());
				System.out.println("mots de passe agence : " + r.getListagence().get(i).getMdp());
				System.out.println("\n");
		    	for(Ihotel h : r.getListagence().get(i).getH()) {
			    	System.out.println("	id hotel : " + h.getid());
			    	System.out.println("	nom hotel : " + h.getNom());
			    	System.out.println("	Nombres etoiles : " + h.getNombreEtoile());
			    	System.out.println("	Nombres lits : " + h.getNombreLit());
			    	System.out.println("\n");
			    	for(Chambre c : h.getListChambre()) {
			    	System.out.println("		numéro chambre : " + c.getNumero());
			    	System.out.println("		nombre de lits : " + c.getNbLit());
				    	for(Reservation d : c.getListRes()) {
				    	       DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
				    	        String date1 = formatter.format(d.getDateArrivee().toGregorianCalendar().getTime());
				    	        String date2 = formatter.format(d.getDateDepart().toGregorianCalendar().getTime());
				    		System.out.println("			reservé du {" + date1 + " au " + date2+ "}");
				    	}
			    	}
			    	System.out.println("\n\n");
		    	}
			}

			break;
		case QUIT:
			System.out.println("Bye...");
			return;
		default:
			System.err.println("Sorry, wrong input. Please try again.");
			return;
		} 
	}	
	/*
	private static void displayEmployee(Employee employee) {
		System.out.println("ID: "+employee.getId()+", Name: "+employee.getName());
	}*/
	

}

