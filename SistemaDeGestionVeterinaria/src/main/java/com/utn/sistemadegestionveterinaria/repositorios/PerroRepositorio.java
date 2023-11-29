package com.utn.sistemadegestionveterinaria.repositorios;

import com.utn.sistemadegestionveterinaria.controladores.PerroController;
import com.utn.sistemadegestionveterinaria.dao.PerroDAO;
import com.utn.sistemadegestionveterinaria.modelos.Perro;
import jakarta.persistence.EntityManagerFactory;

import java.util.List;

public class PerroRepositorio implements PerroDAO {
    private final PerroDAO controlador;
    public PerroRepositorio(){
        controlador = new PerroController();
    }
    public PerroRepositorio(EntityManagerFactory emf){
        controlador = new PerroController(emf);
    }
    @Override
    public void crear(Perro perro){
        controlador.crear(perro);
    }

    @Override
    public Perro traer(Perro perro) {
        controlador.traer(perro);
    }

    @Override
    public void actualizar(Perro perro) {
        controlador.actualizar(perro);
    }

    @Override
    public List<Perro> traerTodo() {
        return controlador.traerTodo();
    }

    @Override
    public boolean existe(Perro perro) {
        return controlador.existe(perro);
    }

    @Override
    public void borrar(Perro perro) {
        controlador.borrar(perro);
    }
}
