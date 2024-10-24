package com.example.demo.entities;

import com.example.demo.exceptions.IllegalToppingException;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "puzze")
@Getter
@ToString
@NoArgsConstructor
public class Pizza extends Prodotto {

// Forza ogni volta la lettura dei toppings, se si usa FETCH nella query lo fa solo quando c'è bisogno
    //@ManyToMany(fetch = FetchType.EAGER)
    @ManyToMany
    @JoinTable(
            name = "pizze_toppings",
            joinColumns = @JoinColumn(name = "pizza_id"),
            inverseJoinColumns = @JoinColumn(name = "topping_id")
    )
    private List<Topping> toppings = new ArrayList<>();

    public Pizza(String name, double kcal, double price, List<Topping> toppings) {
        super(name, kcal, price);
        this.toppings.addAll(toppings);
    }

    @Override
    public double getPrice(){
        return toppings.stream().mapToDouble(Topping::getPrice).sum() + 5.0;
    }

    public void addTopping(Topping nuovoTopping) throws IllegalToppingException {

        if(nuovoTopping.getName().equalsIgnoreCase("ananas"))
            throw new IllegalToppingException();

        this.toppings.add(nuovoTopping);

    }
}
