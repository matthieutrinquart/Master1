package com.example.tp3.Models;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.List;
@Entity(name="locations")
@Access(AccessType.FIELD)
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"} )
public class Location {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long location_id;
    @ManyToMany(mappedBy = "locations")
    @JsonIgnore // Pour ne pas produire des cycles
    private List<User> users;

    @Column
    private int latitude;
    @Column
    private int longitude ;

    public long getLocation_id() {
        return location_id;
    }

    public int getLatitude() {
        return latitude;
    }

    public int getLongitude() {
        return longitude;
    }
}
