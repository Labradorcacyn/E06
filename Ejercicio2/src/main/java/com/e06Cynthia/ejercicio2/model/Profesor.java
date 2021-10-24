package com.e06Cynthia.ejercicio2.model;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@AllArgsConstructor @NoArgsConstructor @Builder
@Getter @Setter
public class Profesor implements Serializable {

    @Id
    @GeneratedValue
    private Long id;

    private String nombre, email;
    private double puntuacion;

    @OneToMany(mappedBy = "profesor", fetch = FetchType.EAGER)
    private List<CursoOnline> cursos;
}
