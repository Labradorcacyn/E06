package com.e06Cynthia.ejercicio2;

import com.e06Cynthia.ejercicio2.model.CursoOnline;
import com.e06Cynthia.ejercicio2.model.Profesor;
import com.e06Cynthia.ejercicio2.model.Video;
import com.e06Cynthia.ejercicio2.service.CursoOnlineService;
import com.e06Cynthia.ejercicio2.service.ProfesorService;
import com.e06Cynthia.ejercicio2.service.VideoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;

@Component
@RequiredArgsConstructor
public class MainDePrueba {

    public final ProfesorService profesorService;
    public final CursoOnlineService cursoService;
    public final VideoService videoService;

    @PostConstruct
    public void test(){
        //Creamos los profesores
        profesorService.save(Profesor.builder()
                .nombre("Luismi")
                .email("luismi.lopez@salesianos.edu")
                .puntuacion(10)
                .build());
        profesorService.save(Profesor.builder()
                .nombre("Miguel")
                .email("miguel.campos@salesianos.edu")
                .puntuacion(10)
                .build());

        //Creamos los cursos online
        cursoService.save(CursoOnline.builder()
                .nombre("Acceso a Datos")
                .puntuacion(10)
                .profesor(profesorService.FindById(1L).orElse(null))
                .build());
        cursoService.save(CursoOnline.builder()
                .nombre("Desarrollo Interfaces")
                .puntuacion(10)
                .profesor(profesorService.FindById(2L).orElse(null))
                .build());
        cursoService.save(CursoOnline.builder()
                .nombre("Programación Multimedia")
                .puntuacion(10)
                .profesor(profesorService.FindById(2L).orElse(null))
                .build());
        cursoService.save(CursoOnline.builder()
                .nombre("Sistemas de Gestión")
                .puntuacion(10)
                .profesor(profesorService.FindById(1L).orElse(null))
                .build());
        //Agregamos la lista de Cursos a la Profesores
        profesorService.save(profesorService.FindById(1L).filter(p->p.getCursos().add(
                cursoService.FindById(3L).orElse(null))).orElse(null));
        profesorService.save(profesorService.FindById(1L).filter(p->p.getCursos().add(
                cursoService.FindById(6L).orElse(null))).orElse(null));
        profesorService.save(profesorService.FindById(2L).filter(p->p.getCursos().add(
                cursoService.FindById(4L).orElse(null))).orElse(null));
        profesorService.save(profesorService.FindById(2L).filter(p->p.getCursos().add(
                cursoService.FindById(5L).orElse(null))).orElse(null));
        //Creamos los videos
        videoService.save(Video.builder()
                .orden("1")
                .titulo("Presentación del modulo profesional")
                .url("https://classroom.google.com/u/2/c/MzIwODkwNDM0NDQ3/m/MzIxMDIyOTcwMjEy/details")
                .descripcion("Conocimientos Básicos del modulo")
                .curso(cursoService.FindById(3L).orElse(null))
                .build());
        videoService.save(Video.builder()
                .orden("2")
                .titulo("Spring Core")
                .url("https://classroom.google.com/u/2/c/MzIwODkwNDM0NDQ3/m/MzkwMTc0MzI1MzA1/details")
                .descripcion("Documentación sobre Spring Core")
                .curso(cursoService.FindById(3L).orElse(null))
                .build());
        videoService.save(Video.builder()
                .orden("1")
                .titulo("Figma")
                .descripcion("Video sobre Figma")
                .url("https://classroom.google.com/u/2/c/MjQwNDU1MTAzOFpa/m/MzQ0OTI5OTE4MjI5/details")
                .curso(cursoService.FindById(4L).orElse(null))
                .build());
        //Agregamos la lista de videos a los cursos
        cursoService.save(cursoService.FindById(3L).filter(c->c.getVideos().add(
                videoService.FindById(7L).orElse(null)
        )).orElse(null));
        cursoService.save(cursoService.FindById(3L).filter(c->c.getVideos().add(
                videoService.FindById(8L).orElse(null)
        )).orElse(null));

        cursoService.save(cursoService.FindById(4L).filter(c->c.getVideos().add(
                videoService.FindById(9L).orElse(null)
        )).orElse(null));
    }
    /*
    H2 BASE DE DATOS
    Para obtener la lista de cursos de los profesores
    SELECT C.ID, C.NOMBRE, PROFESOR_ID, P.NOMBRE FROM CURSO_ONLINE C JOIN PROFESOR P ON(PROFESOR_ID = P.ID);

    Para obtener la lista de Videos de los Cursos
    SELECT V.ID, V.TITULO, CURSO_ID, C.NOMBRE FROM VIDEO V JOIN CURSO_ONLINE C ON(CURSO_ID = C.ID);
    */
}
