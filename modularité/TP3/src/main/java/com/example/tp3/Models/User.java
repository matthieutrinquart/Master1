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

    @Column
    private String first_name;
    @Column
    private String last_name ;
    @Column
    private String email ;
    @Column
    private String phone_number ;
    @Id
    @Column
    @JoinColumn(name="username")
    private String username;
    @Column
    private String password  ;
    @Column
    private Boolean enabled;




    @OneToMany
    @JoinTable(name="authorities",
            joinColumns = @JoinColumn(name="username"),
            inverseJoinColumns = @JoinColumn(name="authority_id"))
    private List<Authorities> authorities;


    public long getUser_id() {
        return user_id;
    }

    public List<Location> getLocations() {
        return locations;
    }

    public String getFirst_name() {
        return first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public String getPassword() {
        return password;
    }

    public List<Authorities> getAuthorities() {
        return authorities;
    }



    public Boolean getEnabled() {
        return enabled;
    }

    public String getUsername() {
        return username;
    }


}
