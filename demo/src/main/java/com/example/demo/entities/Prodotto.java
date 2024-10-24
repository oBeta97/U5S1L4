package com.example.demo.entities;

import jakarta.persistence.*;
import lombok.*;


@Entity
@Table(name = "prodotti")
@Inheritance(strategy = InheritanceType.JOINED)
@NoArgsConstructor
@Getter
@Setter
@ToString
public abstract class Prodotto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private long id;
    private String name;
    private double kcal;
    private double price;

    public Prodotto(String name, double kcal, double price) {
        this.kcal = kcal;
        this.name = name;
        this.price = price;
    }
}
