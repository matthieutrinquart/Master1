package com.example.tp3.Controllers;

import com.example.tp3.Models.User;
import com.example.tp3.Repository.UserRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
public class UsersControllers {
    @Autowired
  private UserRepository userRepository;

    @GetMapping
    public List<User> list(){

        return userRepository.findAll();
    }

    @GetMapping
    @RequestMapping("{id}")
    public User get(@PathVariable Long id){
        return userRepository.getById(id);
    }


    @PostMapping
    @ResponseStatus(HttpStatus.ACCEPTED)
    public User create(@RequestBody final User user){
        return userRepository.saveAndFlush(user);
    }

    @RequestMapping(value = "{id}",method = RequestMethod.DELETE)
    public void delete(@PathVariable Long id) {
        // Toujours verifier s'il faut supprimer aussi
        // les enregistrements enfants
        userRepository.deleteById(id);
    }

    @RequestMapping(value="{id}",method = RequestMethod.PUT)
    public User update(@PathVariable Long id, @RequestBody User user) {
        // TODO: Ajouter ici une validation si tous
        // les champs ont ete passes
        // Sinon, retourner une erreur 400 (Bad Payload)
        User existingUser = userRepository.getById(id);
        BeanUtils.copyProperties(user,existingUser,"user_id");
        return userRepository.saveAndFlush(existingUser);
    }




}
