package com.utn.sistemadegestionveterinaria.logica.medico;

import com.utn.sistemadegestionveterinaria.controladores.MedicoController;
import com.utn.sistemadegestionveterinaria.dao.MedicoDAO;
import com.utn.sistemadegestionveterinaria.logica.RegistroTemplate;
import com.utn.sistemadegestionveterinaria.modelos.Medico;

import java.util.Scanner;

public class MedicoTemplate extends RegistroTemplate {
    private Medico medico = new Medico();
    private Scanner teclado = new Scanner(System.in);
    private MedicoDAO repo = new MedicoController();
    @Override
    public void crearEntidad() {
        System.out.println("Ingrese el nombre del nuevo medico");
        medico.setNombre(teclado.next());
    }
    @Override
    public void persistir() {
        repo.crear(medico);
    }
}
