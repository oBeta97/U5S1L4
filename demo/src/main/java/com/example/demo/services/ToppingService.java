package com.example.demo.services;

import com.example.demo.entities.Topping;
import com.example.demo.repositories.ToppingRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class ToppingService {

    @Autowired
    private ToppingRepository toppingRepo;

    public void save(Topping t) throws Exception {

        if (toppingRepo.existsByName(t.getName())) throw new Exception("Bleah! ANANASSO TASSOFRASSO");

        toppingRepo.save(t);

    }

    public void saveAll(List<Topping> t_list){
        for(Topping t : t_list){
            try {
                this.save(t);
            } catch (Exception e) {
                log.error("TrOPPING!");
            }
        }
    }


    public Topping getToppingByName(String toppingName){

        List<Topping> t = toppingRepo.findByName(toppingName);

        return t.getFirst();

    }

}
