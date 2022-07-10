package main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {
		"models",
		"Cli",
		"Client"
		
})
public class Exo2ComparateurApplication {

	public static void main(String[] args) {
		SpringApplication.run(Exo2ComparateurApplication.class, args);
	}

}
