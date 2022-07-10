package main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EntityScan(basePackages = {
		"Models"
		
})

@EnableJpaRepositories(basePackages = {
		"repositories"
		
})

@SpringBootApplication(scanBasePackages = {
		"Data",
		"Exception",
		"controlers",
		"Client"
		
})
public class Exo2AgenceRest2Application {

	public static void main(String[] args) {
		SpringApplication.run(Exo2AgenceRest2Application.class, args);
	}

}
