package com.example.tp3.Repository;

import com.example.tp3.Models.Location;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Locationrepository extends JpaRepository<Location,Long> {
}
