package Data;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import models.Adresse;
import models.Chambre;
import models.Hotel;
import models.Partenaire;
import repositories.AdresseRepository;
import repositories.ChambreRepository;
import repositories.HotelRepository;
import repositories.PartenaireRepository;
import repositories.ReservationRepository;
@Configuration
public class HotelData {
	
	private Logger logger = LoggerFactory.getLogger(HotelData.class);
	
	@Bean
	public CommandLineRunner initDatabase(HotelRepository repository , ChambreRepository ch , PartenaireRepository part , ReservationRepository Res  , AdresseRepository adr) {
		
		String chemin = "src\\main\\java\\Image_chambre\\" ;
		return args -> {


			
			
			Adresse a = new Adresse("FRANCE" , "Paris","Rue jean moulin" , "ALLO" , 3);
			adr.save(a);
			Hotel h4 = new Hotel(3,"KUMA",1000,6 , a);
			repository.save(h4);
			Chambre ch14 = new Chambre(0,1,chemin + "chambre4.jpg",h4);
			Chambre ch24 = new Chambre(1,2,chemin + "chambre4.jpg",h4);
			Chambre ch34 = new Chambre(2,2,chemin + "chambre4.jpg",h4);
			Chambre ch44 = new Chambre(3,2,chemin + "chambre4.jpg",h4);
			Chambre ch54 = new Chambre(4,3,chemin + "chambre4.jpg",h4);
			Chambre ch64 = new Chambre(5,1,chemin + "chambre4.jpg",h4);
			Chambre ch74 = new Chambre(6,1,chemin + "chambre4.jpg",h4);
			Chambre ch84 = new Chambre(7,1,chemin + "chambre4.jpg",h4);
			ch.save(ch14);
			ch.save(ch24);
			ch.save(ch34);
			ch.save(ch44);
			ch.save(ch54);
			ch.save(ch64);
			ch.save(ch74);
			ch.save(ch84);
			Partenaire P9 = new Partenaire("agence du plaisir" ,1,h4);
			Partenaire P10 = new Partenaire("agence tout risque" ,4,h4);
			Partenaire P11 = new Partenaire("agence du bonheur" ,0,h4);
			
			part.save(P9);
			part.save(P10);
			part.save(P11);
			

			

			
				
		};
		
	}

}
