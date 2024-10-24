package com.example.demo.repositories;

import com.example.demo.entities.Pizza;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PizzaRepository extends JpaRepository<Pizza, Long> {
    boolean existsByName(String nomeProdotto);


    // FETCH forza la "lettura" dei topping, analogo al FetchType.EAGER
    @Query("SELECT p FROM Pizza p JOIN FETCH p.toppings t WHERE t.name = 'Pummarol'")
    List<Pizza> pizzaWithPummarol();

}
