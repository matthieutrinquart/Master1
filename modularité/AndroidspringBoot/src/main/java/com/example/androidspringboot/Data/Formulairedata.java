package com.example.androidspringboot.Data;

import com.example.androidspringboot.models.Hobbit;
import com.example.androidspringboot.models.Formulaire;
import com.example.androidspringboot.repositories.FormulaireRepository;
import com.example.androidspringboot.repositories.HobbitRepository;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.slf4j.Logger;


@Configuration
public class Formulairedata {
    private Logger logger =LoggerFactory.getLogger(Formulairedata.class);

    @Bean
    public CommandLineRunner initDatabase(FormulaireRepository rep , HobbitRepository he ) {
        return args -> {
            Formulaire f = new Formulaire(0,"Monot","Lea","03/03/2000","06 66 66 66 66","lea.monot@gmail.com");
            rep.save(f);
            Hobbit h = new Hobbit(0,"Sport",true,f);
            Hobbit h2 = new Hobbit(1,"Musique",false,f);
            Hobbit h3 = new Hobbit(2,"Lecture",true,f);
            he.save(h);
            he.save(h2);
            he.save(h3);
        };
    }
}
