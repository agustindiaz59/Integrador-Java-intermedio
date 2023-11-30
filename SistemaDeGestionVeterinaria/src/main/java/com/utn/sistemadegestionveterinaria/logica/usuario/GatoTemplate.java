package com.utn.sistemadegestionveterinaria.logica.usuario;

import com.utn.sistemadegestionveterinaria.dao.GatoDAO;
import com.utn.sistemadegestionveterinaria.logica.RegistroTemplate;
import com.utn.sistemadegestionveterinaria.modelos.Gato;
import com.utn.sistemadegestionveterinaria.repositorios.GatoRepositorio;

import java.util.Scanner;

public class GatoTemplate extends RegistroTemplate {
    private Scanner teclado = new Scanner(System.in);
    private GatoDAO repo = new GatoRepositorio();
    private Gato nuevo = new Gato();
    @Override
    public void crearEntidad() {
        System.out.println("Ingrese el nombre del gato");
        nuevo.setNombre(teclado.next());
        System.out.println("Ingrese la raza del gato");
        nuevo.setRaza(teclado.next());
    }

    @Override
    public void persistir() {
        repo.crear(nuevo);
    }
}
