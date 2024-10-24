package com.example.demo.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "toppings")
@NoArgsConstructor
@Getter
@Setter
public class Topping extends Prodotto{

    private double quantita;
    @Column(name = "unita_misura")
    private String unitaMisura;

    @ManyToMany(mappedBy = "toppings")
    @Setter(AccessLevel.NONE)
    private List<Pizza> pizzas;

    public Topping(String name, double kcal, double price, double quantita, String unitaMisura){
        super(name, kcal, price);
        this.quantita = quantita;
        this.unitaMisura = unitaMisura;
    }


}
