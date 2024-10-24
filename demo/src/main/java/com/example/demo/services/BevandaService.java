package com.example.demo.services;

import com.example.demo.entities.Bevanda;
import com.example.demo.repositories.BevandaRepository;
import com.example.demo.repositories.ProdottoRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class BevandaService {

    @Autowired
    private BevandaRepository bevandaRepo;

    @Autowired
    private ProdottoRepository prodottoRepo;

    public void saveBevanda(Bevanda b) throws Exception {

        if(bevandaRepo.existsByName(b.getName())) throw new Exception("bleah");

        bevandaRepo.save(b);

        log.info("Bevanda {} creata!", b.getName());

    }


}
