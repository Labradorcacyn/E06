package com.e06Cynthia.ejercicio2.model;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;


@Entity
@AllArgsConstructor @NoArgsConstructor @Builder
@Getter @Setter
public class CursoOnline implements Serializable {

    @Id
    @GeneratedValue
    private Long id;

    private String nombre;
    private double puntuacion;

    @ManyToOne
    private Profesor profesor;

    @OneToMany(mappedBy = "curso", fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
    private List<Video> videos;
}
