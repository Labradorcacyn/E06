package com.e06Cynthia.ejercicio1.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Entity
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor @Builder
public class Producto implements Serializable {

    @Id
    @GeneratedValue
    private Long id;
    private String nombre;
    private double pvp;

    @ManyToOne
    private Categoria categoria;
}
