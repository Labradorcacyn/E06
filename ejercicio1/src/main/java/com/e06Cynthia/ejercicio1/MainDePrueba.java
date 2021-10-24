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
import java.util.stream.Collectors;

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
        //Agregamos la lista de Categorias a la Categoria Padre
        catPadreService.save(catPadreService.FindById(1L).filter(c->c.getCategorias().add(catService.FindById(3L).orElse(null))).orElse(null));
        catPadreService.save(catPadreService.FindById(1L).filter(c->c.getCategorias().add(catService.FindById(4L).orElse(null))).orElse(null));
        catPadreService.save(catPadreService.FindById(1L).filter(c->c.getCategorias().add(catService.FindById(5L).orElse(null))).orElse(null));
        //Creamos los productos
        prodService.save(Producto.builder().nombre("Sartén").pvp(7.95).categoria(catService.FindById(3L).orElse(null)).build());
        prodService.save(Producto.builder().nombre("Platos").pvp(16.95).categoria(catService.FindById(3L).orElse(null)).build());
        prodService.save(Producto.builder().nombre("Cuadro").pvp(10.59).categoria(catService.FindById(4L).orElse(null)).build());
        prodService.save(Producto.builder().nombre("Alfombrilla de baño").pvp(15.79).categoria(catService.FindById(5L).orElse(null)).build());
        prodService.save(Producto.builder().nombre("Jarrón").pvp(18.20).categoria(catService.FindById(4L).orElse(null)).build());
        //Agregamos la lista de Productos a la Categoria
        catService.save(catService.FindById(3L).filter(c->c.getProductos().add(prodService.FindById(6L).orElse(null))).orElse(null));
        catService.save(catService.FindById(3L).filter(c->c.getProductos().add(prodService.FindById(7L).orElse(null))).orElse(null));
        catService.save(catService.FindById(4L).filter(c->c.getProductos().add(prodService.FindById(8L).orElse(null))).orElse(null));
        catService.save(catService.FindById(4L).filter(c->c.getProductos().add(prodService.FindById(10L).orElse(null))).orElse(null));
        catService.save(catService.FindById(5L).filter(c->c.getProductos().add(prodService.FindById(9L).orElse(null))).orElse(null));

        //BASE DE DATOS H2
        //SELECT * FROM CATEGORIA_PADRE C JOIN CATEGORIA ON (C.ID = CAT_PADRE_ID); // Te devuelve la lista de Categorias de la Categoría Padre
        //SELECT C.ID, C.NOMBRE, P.ID, P.NOMBRE FROM CATEGORIA C JOIN PRODUCTO P ON (C.ID = P.CATEGORIA_ID); // Te devuelve la lista de Productos de la Categoría
        System.out.println("Hola " + catService.FindById(5L).map(c->c.getProductos().size())); // Compruebo que la lista tiene los Productos guardados correctamente
        System.out.println("Hola " + catService.FindById(3L).map(c->c.getProductos().size()));
    }
}
