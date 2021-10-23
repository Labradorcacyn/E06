package com.e06Cynthia.ejercicio1;

import com.e06Cynthia.ejercicio1.model.Categoria;
import com.e06Cynthia.ejercicio1.model.CategoriaPadre;
import com.e06Cynthia.ejercicio1.model.Producto;
import com.e06Cynthia.ejercicio1.service.CategoriaPadreService;
import com.e06Cynthia.ejercicio1.service.CategoriaService;
import com.e06Cynthia.ejercicio1.service.ProductoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
@RequiredArgsConstructor
public class MainDePrueba {

    private final CategoriaService catService;
    private final CategoriaPadreService catPadreService;
    private final ProductoService prodService;

    @PostConstruct
    public void test(){
        //Creamos la categorias Padres
        catPadreService.save(CategoriaPadre.builder().nombre("Hogar").build());
        catPadreService.save(CategoriaPadre.builder().nombre("Ropa").build());
        //Creamos las categorias y agregamos la categoria Padre
        catService.save(Categoria.builder().nombre("Utencilios de cocina").catPadre(catPadreService.FindById(1L).orElse(null)).build());
        catService.save(Categoria.builder().nombre("Salón").catPadre(catPadreService.FindById(1L).orElse(null)).build());
        catService.save(Categoria.builder().nombre("Baño").catPadre(catPadreService.FindById(1L).orElse(null)).build());
        //Agregamos la lista de categorias a la Categoria Padre
        catPadreService.save(catPadreService.FindById(1L).filter(c->c.getCategorias().add(catService.FindById(3L).orElse(null))).orElse(null));
        catPadreService.save(catPadreService.FindById(1L).filter(c->c.getCategorias().add(catService.FindById(4L).orElse(null))).orElse(null));
        catPadreService.save(catPadreService.FindById(1L).filter(c->c.getCategorias().add(catService.FindById(5L).orElse(null))).orElse(null));
        //Creamos los productos
        prodService.save(Producto.builder().nombre("Sartén").pvp(7.95).categoria(catService.FindById(3L).orElse(null)).build());
        prodService.save(Producto.builder().nombre("Platos").pvp(16.95).categoria(catService.FindById(3L).orElse(null)).build());
        prodService.save(Producto.builder().nombre("Cuadro").pvp(10.59).categoria(catService.FindById(4L).orElse(null)).build());
        prodService.save(Producto.builder().nombre("Alfombrilla de baño").pvp(15.79).categoria(catService.FindById(5L).orElse(null)).build());
        prodService.save(Producto.builder().nombre("Jarrón").pvp(18.20).categoria(catService.FindById(4L).orElse(null)).build());



    }

}
