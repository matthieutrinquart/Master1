package Data;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

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
		
		return args -> {
			Adresse a = new Adresse("Mexique" , "Mexico","Rue christophe coloump" , "ALLO" , 3);
			adr.save(a);
			Hotel h2 = new Hotel(1,"Harry Potter",60,3,a);
			repository.save(h2);
			String chemin = "src\\main\\java\\Image_chambre\\" ;
			Chambre ch12 = new Chambre(0,1,chemin + "chambre2.jpg",h2);
			Chambre ch22 = new Chambre(1,2,chemin + "chambre2.jpg",h2);
			Chambre ch32 = new Chambre(2,2,chemin + "chambre2.jpg",h2);
			Chambre ch42 = new Chambre(3,2,chemin + "chambre2.jpg",h2);
			Chambre ch52 = new Chambre(4,3,chemin + "chambre2.jpg",h2);
			Chambre ch62 = new Chambre(5,1,chemin + "chambre2.jpg",h2);
			Chambre ch72 = new Chambre(6,1,chemin + "chambre2.jpg",h2);
			Chambre ch82 = new Chambre(7,1,chemin + "chambre2.jpg",h2);
			ch.save(ch12);
			ch.save(ch22);
			ch.save(ch32);
			ch.save(ch42);
			ch.save(ch52);
			ch.save(ch62);
			ch.save(ch72);
			ch.save(ch82);
			Partenaire P5 = new Partenaire("agence du bonheur" ,0,h2);
			
			part.save(P5);
			
			
			
			
			
			
			

			

			
				
		};
		
	}

}
