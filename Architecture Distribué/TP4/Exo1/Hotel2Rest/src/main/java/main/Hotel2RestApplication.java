package main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@EntityScan(basePackages = {
		"models"
		
})

@EnableJpaRepositories(basePackages = {
		"repositories"
		
})

@SpringBootApplication(scanBasePackages = {
		"Data",
		"Exception",
		"controlers"
		
})
public class Hotel2RestApplication {

	public static void main(String[] args) {
		SpringApplication.run(Hotel2RestApplication.class, args);
	}

}
