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
		
		return args -> {
			Hotel h1 = new Hotel(0,"casa des papels",54,2);
			repository.save(h1);
			String chemin = "src\\main\\java\\Image_chambre\\" ;
			Chambre ch1 = new Chambre(0,3,chemin + "chambre1.jpg",h1);
			Chambre ch2 = new Chambre(1,1,chemin + "chambre1.jpg",h1);
			Chambre ch3 = new Chambre(2,2,chemin + "chambre1.jpg",h1);
			Chambre ch4 = new Chambre(3,2,chemin + "chambre1.jpg",h1);
			Chambre ch5 = new Chambre(4,3,chemin + "chambre1.jpg",h1);
			Chambre ch6 = new Chambre(5,2,chemin + "chambre1.jpg",h1);
			Chambre ch7 = new Chambre(6,1,chemin + "chambre1.jpg",h1);
			Chambre ch8 = new Chambre(7,1,chemin + "chambre1.jpg",h1);
			ch.save(ch1);
			ch.save(ch2);
			ch.save(ch3);
			ch.save(ch4);
			ch.save(ch5);
			ch.save(ch6);
			ch.save(ch7);
			ch.save(ch8);
			Partenaire P1 = new Partenaire("agence du bonheur" ,0,h1);
			Partenaire P2 = new Partenaire("agence du plaisir" ,1,h1);
			
			
			part.save(P1);
			part.save(P2);
			
			
			
			
			
			
			
			

			

			
				
		};
		
	}

}
