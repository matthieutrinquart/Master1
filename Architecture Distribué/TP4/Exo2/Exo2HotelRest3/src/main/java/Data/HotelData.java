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
	public CommandLineRunner initDatabase(HotelRepository repository , ChambreRepository ch , PartenaireRepository part , ReservationRepository Res , AdresseRepository adr) {
		
		String chemin = "src\\main\\java\\Image_chambre\\" ;
		return args -> {


			
			
			Adresse a = new Adresse("FRANCE" , "Paris","Champ Elysée" , "ALLO" , 3);
			adr.save(a);
			Hotel h3 = new Hotel(2,"HELIAD",60,3,a);
			repository.save(h3);
			Chambre ch13 = new Chambre(0,1,chemin + "chambre3.jpg",h3);
			Chambre ch23 = new Chambre(1,2,chemin + "chambre3.jpg",h3);
			Chambre ch33 = new Chambre(2,2,chemin + "chambre3.jpg",h3);
			Chambre ch43 = new Chambre(3,2,chemin + "chambre3.jpg",h3);
			Chambre ch53 = new Chambre(4,3,chemin + "chambre3.jpg",h3);
			Chambre ch63 = new Chambre(5,1,chemin + "chambre3.jpg",h3);
			Chambre ch73 = new Chambre(6,1,chemin + "chambre3.jpg",h3);
			Chambre ch83 = new Chambre(7,1,chemin + "chambre3.jpg",h3);
			ch.save(ch13);
			ch.save(ch23);
			ch.save(ch33);
			ch.save(ch43);
			ch.save(ch53);
			ch.save(ch63);
			ch.save(ch73);
			ch.save(ch83);
			Partenaire P6 = new Partenaire("agence ferrage" ,2,h3);
			Partenaire P7 = new Partenaire("agence tout risque" ,4,h3);
			Partenaire P8 = new Partenaire("agence du bonheur" ,0,h3);
			
			part.save(P6);
			part.save(P7);
			part.save(P8);

			

			
				
		};
		
	}

}
