package com.example.demo.runners;

import com.example.demo.entities.Bevanda;
import com.example.demo.entities.Pizza;
import com.example.demo.entities.Topping;
import com.example.demo.services.BevandaService;
import com.example.demo.services.PizzaService;
import com.example.demo.services.ToppingService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@Slf4j
public class Test implements CommandLineRunner {
    @Autowired
    private BevandaService bevandaService;

    @Autowired
    private PizzaService pizzaService;

    @Autowired
    private ToppingService toppingService;


    @Override
    public void run(String... args) {

        Bevanda b = new Bevanda();
        b.setName("coca-cola");
        b.setPrice(5.0);
        b.setKcal(100.0);
        b.setConCannuccia(false);

        try {
            bevandaService.saveBevanda(b);
        } catch (Exception e) {
            log.error(e.getMessage());
        }

        List<Topping> toppings = new ArrayList<>();

        toppings.add(new Topping("Mozzarella", 200.0, 0.5, 40.0, "gr"));
        toppings.add(new Topping("Pummarol", 200.0, 0.5, 40.0, "gr"));
        toppings.add(new Topping("Prosciut", 200.0, 0.5, 40.0, "gr"));
        toppings.add(new Topping("Funghi", 200.0, 0.5, 40.0, "gr"));

        toppingService.saveAll(toppings);

        toppings.clear();


        toppings.add(toppingService.getToppingByName("Mozzarella"));
        toppings.add(toppingService.getToppingByName("Pummarol"));
        toppings.add(toppingService.getToppingByName("Prosciut"));
        toppings.add(toppingService.getToppingByName("Funghi"));

        Pizza marghe = new Pizza("La classica", 1000.0, 5.0, toppings);

        log.info(marghe.toString());

        try {
            pizzaService.save(marghe);
            log.info("Pizza inserita");
        } catch (Exception e) {
            log.error(e.getMessage());
        }


        List<Pizza> puzzePummarolosissime = pizzaService.pizzePummarolose();

        for(Pizza p : puzzePummarolosissime) log.info(p.toString());


    }
}
