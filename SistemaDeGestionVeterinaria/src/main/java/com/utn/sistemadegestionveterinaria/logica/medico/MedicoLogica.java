package com.utn.sistemadegestionveterinaria.logica.medico;

import com.utn.sistemadegestionveterinaria.controladores.TurnoController;
import com.utn.sistemadegestionveterinaria.dao.MedicoDAO;
import com.utn.sistemadegestionveterinaria.dao.TurnoDAO;
import com.utn.sistemadegestionveterinaria.logica.RegistroTemplate;
import com.utn.sistemadegestionveterinaria.modelos.Medico;
import com.utn.sistemadegestionveterinaria.modelos.Turno;
import com.utn.sistemadegestionveterinaria.repositorios.MedicoRepositorio;

import java.util.Scanner;

public class MedicoLogica extends RegistroTemplate {
    private Scanner teclado = new Scanner(System.in);
    private MedicoDAO repo = new MedicoRepositorio();
    private TurnoDAO repoTurno = new TurnoController();
    private Medico medico = new Medico();
    public void inicio(){
        System.out.println("Ingrese su ID de medico");
        Medico m = new Medico();
        m.setId(teclado.nextLong());
        if(repo.existe(m)){
            System.out.println("Inicio de sesion exitoso");
            medico = repo.traer(m);

            System.out.println("Que operacion desea realizar?");
            System.out.println("1 ----- Aprobar un turno");
            System.out.println("2 ----- Registrar medico");
            System.out.println("3 ----- Agregar un turno");
            switch (teclado.nextInt()){
                case 1:
                    aprobarTurnos();
                    break;
                case 2:
                    registrarMedico();
                    break;
                case 3:
                    agregarTurno();
                    break;
            }

        }else{
            System.out.println("No se encontro un medico con ese id, reintente");
            inicio();
        }
    }
    public void aprobarTurnos(){
        System.out.println("Turnos pendientes: ");
        medico.getTurno().forEach(t -> System.out.println(t.toString()));

        System.out.println("Cual turno desea aprobar por ID?");
        Turno aprobar = new Turno();
        aprobar.setId(teclado.nextLong());
        aprobar.setAprobado(true);

        repoTurno.actualizar(aprobar);

    }
    public void registrarMedico(){
        RegistroTemplate registro = new MedicoTemplate();
        registro.registrar();
    }
    public void agregarTurno(){
        Turno nuevo = new Turno();

        System.out.println("Ingrese la fecha del turno DD-MM-AAAA");
        nuevo.setFecha(teclado.next());

        medico.getTurno().add(nuevo);
        repo.actualizar(medico);
    }
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
