package Cli;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;


import Models.Agence;
import Models.Listagence;
import Models.NewReservation;
import Models.Offre;
import Models.Disponibiliter;

@Component
public class HotelCli extends AbstractMain implements CommandLineRunner{
	@Autowired
	private RestTemplate proxy;
	private Agence agence;
	ArrayList<Agence> listagence = new ArrayList<>();
	Listagence lista;
	private IntegerInputProcessor inputProcessor;
	private static String URI_HOTEL;
	private static String URI_HOTEL_ID;	
	
	
	
	@Override
	public void run(String... args) throws Exception {
		BufferedReader inputReader;
		String userInput = "";
		try {
			inputReader = new BufferedReader(
			new InputStreamReader(System.in));
			//setTestServiceUrl(inputReader);
			listagence.add(new Agence("agence du bonheur" , 0 , 0.5f,"login1","mdp1"));
			listagence.add(new Agence("agence du plaisir" , 1 , 0.7f,"login2","mdp2"));
			listagence.add(new Agence("agence ferrage" , 2 , 0.4f,"login3","mdp3"));
			listagence.add(new Agence("agence pelican" , 3 , 0.2f,"login4","mdp4"));
			listagence.add(new Agence("agence tout risque" , 4 , 0.6f,"login5","mdp5"));
			lista = new Listagence(listagence);
			URI_HOTEL = SERVICE_URL + "/hotel";
			lista.add_hotel(0, "http://localhost:8081/hotelservice/api/hotel");
			lista.add_hotel(0, "http://localhost:8082/hotelservice/api/hotel");
			lista.add_hotel(0, "http://localhost:8083/hotelservice/api/hotel");
			lista.add_hotel(0,"http://localhost:8084/hotelservice/api/hotel");
			
			lista.add_hotel(1, "http://localhost:8081/hotelservice/api/hotel");
			lista.add_hotel(1, "http://localhost:8082/hotelservice/api/hotel");
			lista.add_hotel(1, "http://localhost:8083/hotelservice/api/hotel");
			lista.add_hotel(1,"http://localhost:8084/hotelservice/api/hotel");
			
			
			lista.add_hotel(2, "http://localhost:8081/hotelservice/api/hotel");
			lista.add_hotel(2, "http://localhost:8082/hotelservice/api/hotel");
			lista.add_hotel(2, "http://localhost:8083/hotelservice/api/hotel");
			lista.add_hotel(2,"http://localhost:8084/hotelservice/api/hotel");
			
			
			lista.add_hotel(3, "http://localhost:8081/hotelservice/api/hotel");
			lista.add_hotel(3, "http://localhost:8082/hotelservice/api/hotel");
			lista.add_hotel(3, "http://localhost:8083/hotelservice/api/hotel");
			lista.add_hotel(3,"http://localhost:8084/hotelservice/api/hotel");
			
			lista.add_hotel(4, "http://localhost:8081/hotelservice/api/hotel");
			lista.add_hotel(4, "http://localhost:8082/hotelservice/api/hotel");
			lista.add_hotel(4, "http://localhost:8083/hotelservice/api/hotel");
			lista.add_hotel(4,"http://localhost:8084/hotelservice/api/hotel");
			
	
			
		do {
			menu();
			userInput = inputReader.readLine();
			processUserInput(inputReader, userInput, proxy);
			Thread.sleep(3000);
		} while(!userInput.equals(QUIT));
		}  catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		
	}
	
	
	@Override
	protected boolean validServiceUrl() {
		return SERVICE_URL.equals("http://localhost:8080/hotelservice/api");
	}

	@Override
	protected void menu() {
		StringBuilder builder = new StringBuilder();
		builder.append(QUIT+". Quit.");
		builder.append("\n1. Reserver");
		builder.append("\n2. voir offre");
		System.out.println(builder);
		
	}

	
	
	private void processUserInput(BufferedReader reader,
			String userInput, RestTemplate proxy) throws IOException, ParseException {
			Map<String,String> params = new HashMap<>();
			inputProcessor = new IntegerInputProcessor(reader);
			switch(userInput) {			
			case "1":
				
				System.out.println("ID Agence :");
				String Id_Agence = reader.readLine();
				int Iid_Agence = Integer.parseInt(Id_Agence);
				
				System.out.println("login Agence :");
				String Login = reader.readLine();
				
				System.out.println("mdp Agence :");
				String mdp = reader.readLine();
				
				System.out.println("ID Hotel :");
				String Id_Hotel = reader.readLine();
				int Iid_Hotel = Integer.parseInt(Id_Hotel);
				
				
				System.out.println("Date debut reservation :");
				String Date1 = reader.readLine();
				
				System.out.println("Date Fin reservation :");
				String Date2 = reader.readLine();
				
				
				System.out.println("Nombre de personne :");
				String nbpers = reader.readLine();
				int Inbpers = Integer.parseInt(nbpers);
				
				System.out.println("Numero chambre :");
				String num_chambre = reader.readLine();
				int Inumchambre = Integer.parseInt(num_chambre);
				
				System.out.println("Nom client :");
				String Nom = reader.readLine();
				
				System.out.println("Prenom client :");
				String Prenom = reader.readLine();
				
				System.out.println("Info carte :");
				String InfoCarte = reader.readLine();
				int IInfo_carte = Integer.parseInt(InfoCarte);
				

			    Date date_arrivé_res = new SimpleDateFormat("dd/MM/yyyy").parse(Date1);
			    Date date_départ_res = new SimpleDateFormat("dd/MM/yyyy").parse(Date2);
			    NewReservation result = lista.Reserver(Iid_Agence,date_arrivé_res, date_départ_res, Inbpers, Iid_Hotel, Inumchambre, Nom, Prenom, IInfo_carte, Login, mdp,proxy);
				
				if(result != null) {
					System.out.println("L'enregistremement c'est fait");
					System.out.println("Chambre numero : " + result.getCh().getNumero());
					System.out.println("Du : " + result.getRes().getDate_arrivee() + " au " + result.getRes().getDate_depart());
					
				}
				else
					System.out.println("erreur dans l'enregistrement");
				
				
				
				
			break;
			
			case "2":
				System.out.println("ID Agence :");
				  Id_Agence = reader.readLine();
				  Iid_Agence = Integer.parseInt(Id_Agence);
				  
					System.out.println("Mots de passe agence :");
					  mdp = reader.readLine();
				
				
				
				System.out.println("Date debut reservation :");
				 Date1 = reader.readLine();
				
				System.out.println("Date Fin reservation :");
				 Date2 = reader.readLine();
				
				System.out.println("Nombre de personne :");
				nbpers = reader.readLine();
				Inbpers = Integer.parseInt(nbpers);
					 
					 
				
				
			     date_arrivé_res = new SimpleDateFormat("dd/MM/yyyy").parse(Date1);
			     date_départ_res = new SimpleDateFormat("dd/MM/yyyy").parse(Date2);
			     ArrayList<Offre> l = lista.lookup(Iid_Agence, date_arrivé_res, date_départ_res, Inbpers, mdp, proxy);
			     if(l != null) {
				     for(Offre o : l) {
				    	 System.out.println("Nom Hotel : " + o.getNom());
				    	 System.out.println("ID Hotel : " + o.getId_offre());
				    	 System.out.println("	Nombre de lit : " + o.getNb_lits());
				    	 System.out.println("	numero de la chambre : " + o.getNumero_chambre());
				    	 System.out.println("	Prix de la chambre : " + o.getPrix());
			    		 System.out.println("	Disponible du : ");
				    	 for(Disponibiliter d : o.getDisponible()) {
				    		 System.out.println("		du " + d.date1 + " au " + d.date2);
				    		 
				    		 
				    	 }
				    	 o.EcrireImage();
				    	 System.out.println();
	
				    	 
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


}
