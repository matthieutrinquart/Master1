package com.example.tp3.Models;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;
@Entity(name="location")
@Access(AccessType.FIELD)
public class Location {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long location_id;
    @ManyToMany(mappedBy = "locations")
    @JsonIgnore // Pour ne pas produire des cycles
    private List<User> users;




}
