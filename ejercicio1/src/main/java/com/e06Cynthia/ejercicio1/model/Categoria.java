package com.e06Cynthia.ejercicio1.model;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor @Builder
public class Categoria implements Serializable {

    @Id
    @GeneratedValue
    private Long id;
    private String nombre;

    @OneToMany(mappedBy="categoria", fetch = FetchType.EAGER)
    private List<Producto> productos;

    @ManyToOne
    private CategoriaPadre catPadre;
}
