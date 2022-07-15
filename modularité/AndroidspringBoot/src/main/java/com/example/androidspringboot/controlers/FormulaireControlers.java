package com.example.androidspringboot.controlers;

import com.example.androidspringboot.models.Hobbit;
import com.example.androidspringboot.models.Formulaire;
import com.example.androidspringboot.repositories.FormulaireRepository;
import com.example.androidspringboot.repositories.HobbitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class FormulaireControlers {
    @Autowired
    private FormulaireRepository formulairerepository;
    @Autowired
    private HobbitRepository hobbitrepo;

    private static final String uri = "formulaire/api";
    @GetMapping(uri + "/form")
    public Formulaire Getformulaire() {
        Optional<Formulaire> c	= formulairerepository.findById((long) 0);
        return c.get();
    }
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(uri+"/formulaire")
    public Formulaire Postformulaire(@RequestBody Formulaire f) {
        this.hobbitrepo.findById((long)0).map(Hobbit -> {
                    Hobbit.setNom(f.getHobbit().get(0).getNom());
                    Hobbit.setVal(f.getHobbit().get(0).isVal());
                    return hobbitrepo.save(Hobbit);
                })
                .orElseGet(() -> hobbitrepo.save(f.getHobbit().get(0)));
        this.hobbitrepo.findById((long)1).map(Hobbit -> {
                    Hobbit.setNom(f.getHobbit().get(1).getNom());
                    Hobbit.setVal(f.getHobbit().get(1).isVal());
                    return hobbitrepo.save(Hobbit);
                })
                .orElseGet(() -> hobbitrepo.save(f.getHobbit().get(1)));
        this.hobbitrepo.findById((long)2).map(Hobbit -> {
                    Hobbit.setNom(f.getHobbit().get(2).getNom());
                    Hobbit.setVal(f.getHobbit().get(2).isVal());
                    return hobbitrepo.save(Hobbit);
                })
                .orElseGet(() -> hobbitrepo.save(f.getHobbit().get(2)));
        return formulairerepository.findById((long) 0)
                .map(formulaire -> {
                    formulaire.setNom(f.getNom());
                    formulaire.setPrenom(f.getPrenom());
                    formulaire.setDate(f.getDate());
                    formulaire.setNum(f.getNum());
                    formulaire.setMail(f.getMail());
                    return formulairerepository.save(formulaire);
                })
                .orElseGet(() -> formulairerepository.save(f));
    }




}
