package com.e06Cynthia.ejercicio1.service;

import com.e06Cynthia.ejercicio1.model.Categoria;
import com.e06Cynthia.ejercicio1.repository.CategoriaRepository;
import com.e06Cynthia.ejercicio1.service.base.BaseService;
import org.springframework.stereotype.Service;

@Service
public class CategoriaService extends BaseService <Categoria, Long, CategoriaRepository> {
}
