package com.utn.sistemadegestionveterinaria.dao;

import com.utn.sistemadegestionveterinaria.modelos.Turno;

import java.util.List;

public interface TurnoDAO {
    void crear(Turno turno);
    Turno traer(Turno turno);
    void actualizar(Turno turno);
    List<Turno> traerTodo();//Uso de stream
    void borrar(Turno turno);
    boolean existe(Turno turno);
}
