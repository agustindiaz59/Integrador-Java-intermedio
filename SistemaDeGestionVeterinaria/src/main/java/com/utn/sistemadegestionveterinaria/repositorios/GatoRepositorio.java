package com.utn.sistemadegestionveterinaria.repositorios;

import com.utn.sistemadegestionveterinaria.controladores.GatoController;
import com.utn.sistemadegestionveterinaria.dao.GatoDAO;
import com.utn.sistemadegestionveterinaria.modelos.Gato;

import java.util.List;

public class GatoRepositorio implements GatoDAO {
    private final GatoDAO controlador;

    public GatoRepositorio() {
        this.controlador = new GatoController();
    }

    @Override
    public void crear(Gato gato) {
        controlador.crear(gato);
    }

    @Override
    public Gato traer(Gato gato) {
        return controlador.traer(gato);
    }

    @Override
    public void actualizar(Gato gato) {
        controlador.actualizar(gato);
    }

    @Override
    public void borrar(Gato gato){
        controlador.borrar(controlador.traer(gato));
    }

    @Override
    public List<Gato> traerTodo() {
        return controlador.traerTodo();
    }

    @Override
    public boolean existe(Gato gato) {
        return controlador.existe(gato);
    }
}
