package com.example.demo.runners;

import com.example.demo.entities.Bevanda;
import com.example.demo.services.BevandaService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class Test implements CommandLineRunner {
    @Autowired
    private BevandaService bevandaService;


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


    }
}
