package com.example.demo.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "bevande")
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Bevanda extends Prodotto{

    private boolean conCannuccia;
}
