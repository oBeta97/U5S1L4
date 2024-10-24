package com.example.demo.repositories;

import com.example.demo.entities.Topping;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ToppingRepository extends JpaRepository<Topping, Long> {

    boolean existsByName(String nomeProdotto);

    List<Topping> findByName(String name);

}
