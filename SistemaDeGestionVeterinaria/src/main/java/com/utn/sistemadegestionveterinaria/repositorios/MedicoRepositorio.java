package com.utn.sistemadegestionveterinaria.repositorios;

import com.utn.sistemadegestionveterinaria.controladores.MedicoController;
import com.utn.sistemadegestionveterinaria.dao.MedicoDAO;
import com.utn.sistemadegestionveterinaria.modelos.Medico;

import java.util.List;

public class MedicoRepositorio implements MedicoDAO {
    private MedicoDAO controlador;

    public MedicoRepositorio() {
        controlador = new MedicoController();
    }

    @Override
    public void crear(Medico medico) {
        controlador.crear(medico);
    }

    @Override
    public Medico traer(Medico medico) {
        return controlador.traer(medico);
    }

    @Override
    public void actualizar(Medico medico) {
        controlador.actualizar(medico);
    }

    @Override
    public void borrar(Medico medico) {
        controlador.borrar(medico);
    }

    @Override
    public List<Medico> traerTodo() {
        return controlador.traerTodo();
    }

    @Override
    public boolean existe(Medico medico) {
        return controlador.existe(medico);
    }
}
