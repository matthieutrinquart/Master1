package com.example.tp3.Models;




import javax.persistence.*;
import java.util.List;
@Entity(name="users")
@Access(AccessType.FIELD)
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long user_id;
    @ManyToMany
    @JoinTable(name="user_locations",
            joinColumns = @JoinColumn(name="user_id"),
            inverseJoinColumns = @JoinColumn(name="location_id"))
    private List<Location> locations;



}
