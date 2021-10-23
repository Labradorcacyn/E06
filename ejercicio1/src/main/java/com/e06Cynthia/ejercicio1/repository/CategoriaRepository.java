package com.e06Cynthia.ejercicio1.repository;

import com.e06Cynthia.ejercicio1.model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
}
