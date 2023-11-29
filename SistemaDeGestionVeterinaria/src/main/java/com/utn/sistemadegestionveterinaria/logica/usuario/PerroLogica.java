package com.utn.sistemadegestionveterinaria.logica.usuario;

import com.utn.sistemadegestionveterinaria.dao.PerroDAO;
import com.utn.sistemadegestionveterinaria.logica.RegistroTemplate;
import com.utn.sistemadegestionveterinaria.modelos.Perro;
import com.utn.sistemadegestionveterinaria.repositorios.PerroRepositorio;

import java.util.Scanner;

public class PerroLogica extends RegistroTemplate {
    private Scanner teclado = new Scanner(System.in);
    private Perro nuevo = new Perro();
    private PerroDAO repo = new PerroRepositorio();
    @Override
    public void crearEntidad() {
        System.out.println("Ingrese el nombre del nuevo perro");
        nuevo.setNombre(teclado.next());
        System.out.println("Ingrese la raza del perro");
        nuevo.setRaza(teclado.next());
    }
    @Override
    public void persistir() {
        repo.crear(nuevo);
    }
}
