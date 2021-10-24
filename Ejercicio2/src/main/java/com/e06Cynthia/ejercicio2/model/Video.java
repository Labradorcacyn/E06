package com.e06Cynthia.ejercicio2.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Entity
@NoArgsConstructor @AllArgsConstructor @Builder
@Getter @Setter
public class Video implements Serializable {

    @Id
    @GeneratedValue
    private Long id;

    private String orden, titulo, descripcion, url;

    @ManyToOne
    private CursoOnline curso;
}
