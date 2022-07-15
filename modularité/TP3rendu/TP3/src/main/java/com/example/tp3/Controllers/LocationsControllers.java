package com.example.tp3.Controllers;

import com.example.tp3.Models.Location;
import com.example.tp3.Models.User;
import com.example.tp3.Repository.Locationrepository;
import com.example.tp3.Repository.UserRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/loc")
public class LocationsControllers {
        @Autowired
    private Locationrepository locationRepository;
    @GetMapping
    public List<Location> list(){

        return locationRepository.findAll();
    }

    @GetMapping
    @RequestMapping("{id}")
    public Location get(@PathVariable Long id){
        return locationRepository.getById(id);
    }


    @PostMapping
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Location create(@RequestBody final Location loc){
        return locationRepository.saveAndFlush(loc);
    }

    @RequestMapping(value = "{id}",method = RequestMethod.DELETE)
    public void delete(@PathVariable Long id) {
        // Toujours verifier s'il faut supprimer aussi
        // les enregistrements enfants
        locationRepository.deleteById(id);
    }

    @RequestMapping(value="{id}",method = RequestMethod.PUT)
    public Location update(@PathVariable Long id, @RequestBody Location user) {
        // TODO: Ajouter ici une validation si tous
        // les champs ont ete passes
        // Sinon, retourner une erreur 400 (Bad Payload)
        Location existingUser = locationRepository.getById(id);
        BeanUtils.copyProperties(user,existingUser,"user_id");
        return locationRepository.saveAndFlush(existingUser);
    }

}