package com.e06Cynthia.ejercicio2.service.base;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public abstract class BaseService <T, ID, R extends JpaRepository<T,ID>>{

    @Autowired
    protected R repositorio;

    public List<T> FindAll(){
        return repositorio.findAll();
    }

    public Optional<T> FindById(ID id){
       return repositorio.findById(id);
    }

    public T save(T t){
        return repositorio.save(t);
    }

    public void delete(T t){
        repositorio.delete(t);
    }

    public void deleteById(ID id){
        repositorio.deleteById(id);
    }
}
