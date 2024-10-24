package com.example.demo.entities;

import com.example.demo.exceptions.IllegalToppingException;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "puzze")
@Getter
@ToString
public class Pizza extends Prodotto {
    @ManyToMany
    @JoinTable(
            name = "pizze_toppings",
            joinColumns = @JoinColumn(name = "pizza_id"),
            inverseJoinColumns = @JoinColumn(name = "topping_id")
    )
    private List<Topping> toppings = new ArrayList<>();

    public Pizza(){
        super("margherita", 700, 3.5);

        this.toppings.add(new Topping("pomodoro", 100.0, 1.0, 50.0, "gr"));
        this.toppings.add(new Topping("Mozzarella", 200.0, 0.5, 40.0, "gr"));
    }

    public Pizza(String name, double kcal, double price, List<Topping> toppings) {
        super(name, kcal, price);

        this.toppings.add(new Topping("pomodoro", 100.0, 1.0, 50.0, "gr"));
        this.toppings.add(new Topping("Mozzarella", 200.0, 0.5, 40.0, "gr"));

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
