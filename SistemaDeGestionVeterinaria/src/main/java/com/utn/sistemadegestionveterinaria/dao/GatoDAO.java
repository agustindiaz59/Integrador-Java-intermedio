package com.utn.sistemadegestionveterinaria.dao;

import com.utn.sistemadegestionveterinaria.modelos.Gato;

import java.util.List;

public interface GatoDAO {
    void crear(Gato gato);
    Gato traer(Gato gato);
    void actualizar(Gato gato);
    void borrar(Gato gato);
    List<Gato> traerTodo();//Uso de stream
    boolean existe(Gato gato);
}
