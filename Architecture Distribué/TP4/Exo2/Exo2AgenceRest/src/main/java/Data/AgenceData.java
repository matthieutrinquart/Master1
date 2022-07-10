package Data;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import Models.Agence;
import repositories.AgenceRepository;



@Configuration
public class AgenceData {
	
	private Logger logger = LoggerFactory.getLogger(AgenceData.class);
	
	@Bean
	public CommandLineRunner initDatabase(AgenceRepository agence) {
		
		return args -> {

			List<String> k = new ArrayList<>();
			k.add("http://localhost:8081/hotelservice/api/hotel");
			k.add("http://localhost:8083/hotelservice/api/hotel");
			Agence a = new Agence("agence du plaisir" , 1 , 0.5f ,"login1","mdp1",k);
			
			agence.save(a);
				
		};
		
	}

}