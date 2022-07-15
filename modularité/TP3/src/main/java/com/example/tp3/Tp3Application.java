package com.example.tp3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
public class Tp3Application {

    public static void main(String[] args) {
        SpringApplication.run(Tp3Application.class, args);
    }

}
