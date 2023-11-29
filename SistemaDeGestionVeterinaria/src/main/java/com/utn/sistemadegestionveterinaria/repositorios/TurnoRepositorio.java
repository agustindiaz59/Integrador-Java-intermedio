package com.utn.sistemadegestionveterinaria.repositorios;

import com.utn.sistemadegestionveterinaria.controladores.TurnoController;
import com.utn.sistemadegestionveterinaria.dao.TurnoDAO;
import com.utn.sistemadegestionveterinaria.modelos.Turno;

import java.util.List;

public class TurnoRepositorio implements TurnoDAO {
    private final TurnoDAO controlador;

    public TurnoRepositorio() {
        this.controlador = new TurnoController();
    }

    @Override
    public void crear(Turno turno) {
        if(!controlador.existe(turno)) controlador.crear(turno);
        else System.out.println("El turno ya existe");
    }

    @Override
    public Turno traer(Turno turno) {
        if(controlador.existe(turno)) return controlador.traer(turno);
        else {
            System.out.println("El turno no existe");
            return null;
        }
    }

    @Override
    public void actualizar(Turno turno) {
        if(controlador.existe(turno)) controlador.actualizar(turno);
        else System.out.println("El turno no existe");
    }

    @Override
    public List<Turno> traerTodo() {
        return controlador.traerTodo();
    }

    @Override
    public void borrar(Turno turno) {
        if(controlador.existe(turno)) controlador.borrar(controlador.traer(turno));
        else System.out.println("El turno no existe");
    }

    @Override
    public boolean existe(Turno turno) {
        return controlador.existe(turno);
    }

}
