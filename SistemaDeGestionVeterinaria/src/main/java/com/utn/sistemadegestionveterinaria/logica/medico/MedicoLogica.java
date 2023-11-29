package com.utn.sistemadegestionveterinaria.logica.medico;

import com.utn.sistemadegestionveterinaria.dao.MedicoDAO;
import com.utn.sistemadegestionveterinaria.logica.RegistroTemplate;
import com.utn.sistemadegestionveterinaria.modelos.Medico;
import com.utn.sistemadegestionveterinaria.repositorios.MedicoRepositorio;

import java.util.Scanner;

public class MedicoLogica extends RegistroTemplate {
    private Scanner teclado = new Scanner(System.in);
    private MedicoDAO repo = new MedicoRepositorio();
    private Medico nuevo = new Medico();
    @Override
    public void crearEntidad() {
        System.out.println("Ingrese el nombre del nuevo medico");
        nuevo.setNombre(teclado.next());
    }

    @Override
    public void persistir() {
        repo.crear(nuevo);
    }
}
