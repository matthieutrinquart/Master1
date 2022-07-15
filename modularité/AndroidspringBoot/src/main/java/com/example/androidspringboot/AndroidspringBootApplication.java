package com.example.androidspringboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@EntityScan(basePackages = {
        "com.example.androidspringboot.models"

})

@EnableJpaRepositories(basePackages = {
        "com.example.androidspringboot.repositories"

})

@SpringBootApplication(scanBasePackages = {
        "com.example.androidspringboot.Data",
        "com.example.androidspringboot.controlers"

})

public class AndroidspringBootApplication {

    public static void main(String[] args) {
        SpringApplication.run(AndroidspringBootApplication.class, args);
    }

}
