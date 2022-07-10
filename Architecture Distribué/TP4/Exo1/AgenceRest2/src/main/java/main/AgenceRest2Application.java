package main;

import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {
		"models",
		"Cli",
		"Client"
		
})
public class AgenceRest2Application {

	public static void main(String[] args) {
		SpringApplication.run(AgenceRest2Application.class, args);
	}

}
