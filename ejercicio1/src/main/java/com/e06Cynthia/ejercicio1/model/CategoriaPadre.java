package com.e06Cynthia.ejercicio1.model;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor @Builder
public class CategoriaPadre implements Serializable {

    @Id
    @GeneratedValue
    private Long Id;

    private String nombre;

    @OneToMany(mappedBy = "catPadre", fetch = FetchType.EAGER)
    private List <Categoria> categorias;
}
