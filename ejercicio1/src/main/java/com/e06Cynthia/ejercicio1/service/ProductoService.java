package com.e06Cynthia.ejercicio1.service;

import com.e06Cynthia.ejercicio1.model.Producto;
import com.e06Cynthia.ejercicio1.repository.ProductoRepository;
import com.e06Cynthia.ejercicio1.service.base.BaseService;
import org.springframework.stereotype.Service;

@Service
public class ProductoService extends BaseService<Producto, Long, ProductoRepository> {
}
