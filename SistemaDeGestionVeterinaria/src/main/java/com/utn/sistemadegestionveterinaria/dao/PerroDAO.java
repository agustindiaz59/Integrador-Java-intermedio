package com.utn.sistemadegestionveterinaria.dao;

import com.utn.sistemadegestionveterinaria.modelos.Perro;

import java.util.List;

public interface PerroDAO {
    void crear(Perro perro);
    Perro traer(Perro perro);
    void actualizar(Perro perro);
    void borrar(Perro perro);
    List<Perro> traerTodo();//Uso de stream
    boolean existe(Perro perro);
}
