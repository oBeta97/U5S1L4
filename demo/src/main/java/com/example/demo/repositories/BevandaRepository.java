package com.example.demo.repositories;

import com.example.demo.entities.Bevanda;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BevandaRepository extends JpaRepository<Bevanda, Long> {
    boolean existsByName(String nomeProdotto);

}
