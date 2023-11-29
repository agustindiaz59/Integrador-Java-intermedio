package com.utn.sistemadegestionveterinaria.dao;

import com.utn.sistemadegestionveterinaria.modelos.Gato;
import com.utn.sistemadegestionveterinaria.modelos.Medico;

import java.util.List;

public interface MedicoDAO {
    void crear(Medico medico);
    Medico traer(Medico medico);
    void actualizar(Medico medico);
    void borrar(Medico medico);
    List<Medico> traerTodo();//Uso de stream
    boolean existe(Medico medico);
}
