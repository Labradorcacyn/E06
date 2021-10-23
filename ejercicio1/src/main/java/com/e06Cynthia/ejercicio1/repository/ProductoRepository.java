package com.e06Cynthia.ejercicio1.repository;

import com.e06Cynthia.ejercicio1.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductoRepository extends JpaRepository<Producto,Long> {
}
