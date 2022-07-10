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

import models.Chambre;
import models.Client;
import models.Hotel;
import models.Partenaire;
import models.Reservation;
import repositories.ChambreRepository;
import repositories.ClientRepository;
import repositories.HotelRepository;
import repositories.PartenaireRepository;
import repositories.ReservationRepository;
@Configuration
public class HotelData {
	
	private Logger logger = LoggerFactory.getLogger(HotelData.class);
	
	@Bean
	public CommandLineRunner initDatabase(HotelRepository repository , ChambreRepository ch , PartenaireRepository part , ReservationRepository Res , ClientRepository cl) {
		String chemin = "src\\main\\java\\Image_chambre\\" ;
		return args -> {
		
			
			
			
			
			
			
			
			
			Hotel h2 = new Hotel(1,"Harry Potter",60,3);
			repository.save(h2);
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
			Partenaire P3 = new Partenaire("agence ferrage" ,2,h2);
			Partenaire P4 = new Partenaire("agence pelican" ,3,h2);
			Partenaire P5 = new Partenaire("agence du bonheur" ,0,h2);
			
			part.save(P3);
			part.save(P4);
			part.save(P5);
			
			
			
			
			

			

			
				
		};
		
	}

}
