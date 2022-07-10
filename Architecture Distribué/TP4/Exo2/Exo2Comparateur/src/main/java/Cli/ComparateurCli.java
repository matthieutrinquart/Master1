package Cli;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import Models.Comparateur;
import Models.Offre;


@Component
public class ComparateurCli extends AbstractMain implements CommandLineRunner{
	@Autowired
	private RestTemplate proxy;
	private Comparateur cp;
	private IntegerInputProcessor inputProcessor;
	private static String URI_HOTEL;
	private static String URI_HOTEL_ID;	
	
	
	
	@Override
	public void run(String... args) throws Exception {
		ArrayList<String> t = new ArrayList<>();
		t.add("http://localhost:8080/agence/api");
		t.add("http://localhost:8090/agence/api");
		cp = new Comparateur(t);
		BufferedReader inputReader;
		String userInput = "";
		try {
			inputReader = new BufferedReader(
			new InputStreamReader(System.in));

			
	
			
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
		builder.append("\n1. voir offre");
		System.out.println(builder);
		
	}

	
	
	private void processUserInput(BufferedReader reader,
			String userInput, RestTemplate proxy) throws IOException, ParseException {
			Map<String,String> params = new HashMap<>();
			inputProcessor = new IntegerInputProcessor(reader);
			switch(userInput) {			
			case "1":
				
				
				System.out.println("Ville :");
				String ville = reader.readLine();
	
				
				System.out.println("Date debut reservation :");
				String Date1 = reader.readLine();
				
				System.out.println("Date Fin reservation :");
				String Date2 = reader.readLine();
				
				
				
				System.out.println("Nombre de personne à heberger :");
				String Nb_personne = reader.readLine();
				int Inb_personne= Integer.parseInt(Nb_personne);
				
				System.out.println("Nombre d'etoiles :");
				String Nb_etoile = reader.readLine();
				int Inb_etoile= Integer.parseInt(Nb_etoile);
				
				

				
				Date debut = new SimpleDateFormat("dd/MM/yyyy").parse(Date1);
				Date fin = new SimpleDateFormat("dd/MM/yyyy").parse(Date2);
				
				
				ArrayList<Offre> l =cp.Lookup(ville, debut, fin, Inb_personne, Inb_etoile, proxy);
				
				
			     for(Offre o : l) {
			    	 System.out.println("Nom de l'agence : " + o.getNom_agence());
			    	 System.out.println("	Nom Hotel : " + o.getNom());
			    	 System.out.println("	numero de chambre : " + o.getNum_chambre());
			    	 System.out.println("	Nombre de lit : " + o.getNb_lits());
			    	 System.out.println("	Prix de la chambre : " + o.getPrix());
		    		 System.out.println("	Adresse : ");
		    		 System.out.println("		Pays : " + o.getAdr().getPays());
		    		 System.out.println("		Ville : " + o.getAdr().getVille());
		    		 System.out.println("		Rue : " + o.getAdr().getRue());
		    		 System.out.println("		Numero : " + o.getAdr().getNumero());
		    		 System.out.println("		Lieu-dit : " + o.getAdr().getLieu_dit());

			    	 
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
