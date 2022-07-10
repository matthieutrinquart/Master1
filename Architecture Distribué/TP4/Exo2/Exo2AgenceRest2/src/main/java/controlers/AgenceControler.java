package controlers;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import Models.Agence;
import Models.Offre;
import repositories.AgenceRepository;



@RestController
public class AgenceControler {
	
	private static final String uri = "agence/api";
	
	@Autowired
	private AgenceRepository repository;
	
	@Autowired
	private RestTemplate proxy;
	//ville
	//d'hébergement, dates début et fin de la réservation, nombre de personnes à héberger et le
	//type d'hôtel (nombre minimum d'étoiles).
	
	@GetMapping(uri + "/agence")
	public List<Agence> getAllHotels(){
		
		return repository.findAll();
	}
	
	
	@GetMapping(uri + "/agence/Lookup/ville={ville}from={date},to={date1},beds={lits},stars={nb_etoile}")
	public Offre[] Lookup(@PathVariable String ville,@PathVariable String date, @PathVariable String date1, @PathVariable int lits, @PathVariable int nb_etoile) throws ParseException, IOException  {
		
		
		Optional<Agence> a = repository.findById((long)2);
		//lDate date, Date date1,  int lits,  int id_partenaire,  float pourcentage_reduc,String mdp ,RestTemplate proxy
		

		ArrayList<Offre> of = a.get().Lookup( ville,date, date1, lits,(int) a.get().getId_agence(), a.get().getReduction(),nb_etoile ,proxy);
		
		Offre[] retour =of.toArray(new Offre[0]);
		
	
		
		
		
		
		
		
		
		
		return retour;
	}
	
	

}
