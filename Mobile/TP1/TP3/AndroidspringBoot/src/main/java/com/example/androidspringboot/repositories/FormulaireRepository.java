package com.example.androidspringboot.repositories;

import com.example.androidspringboot.models.Formulaire;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FormulaireRepository extends JpaRepository<Formulaire,Long> {
}
