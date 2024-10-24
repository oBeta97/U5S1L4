package com.example.demo.services;

import com.example.demo.entities.Pizza;
import com.example.demo.repositories.PizzaRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class PizzaService {

    @Autowired
    private PizzaRepository pizzaRepo;

    public void save(Pizza p) throws Exception {

        if (pizzaRepo.existsByName(p.getName())) throw new Exception("Puzza bleah!");

        pizzaRepo.save(p);
    }

    public List<Pizza> pizzePummarolose (){
        return pizzaRepo.pizzaWithPummarol();
    }
}
