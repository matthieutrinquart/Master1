package com.example.androidspringboot.repositories;

import com.example.androidspringboot.models.Hobbit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HobbitRepository extends JpaRepository<Hobbit,Long> {
}
