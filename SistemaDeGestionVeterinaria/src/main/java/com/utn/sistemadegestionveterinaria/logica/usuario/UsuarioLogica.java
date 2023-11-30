package com.utn.sistemadegestionveterinaria.logica.usuario;

import com.utn.sistemadegestionveterinaria.logica.Inicio;
import com.utn.sistemadegestionveterinaria.logica.RegistroTemplate;

import java.util.Scanner;

public class UsuarioLogica {
    private Scanner teclado = new Scanner(System.in);
    public void usuario(Inicio inicio){
        System.out.println();
        System.out.println("Bienvenido");
        System.out.println("1 ----- Registrar mascota");
        System.out.println("2 ----- Sacar turno");
        System.out.println("3 ----- Volver");
        switch (teclado.nextInt()){
            case 1:
                registrarMascota();
                break;
            case 2:
                sacarTurno();
                break;
            case 3:
                inicio.menu();
                break;
            default:
                System.out.println("Error de ingreso, elija una opcion correcta");
                usuario(inicio);
        }
    }
    public void registrarMascota(){
        RegistroTemplate registro; // uso del patron de diseño template

        System.out.println("Que desea registrar?");
        System.out.println("1 ----- Perro");
        System.out.println("2 ----- Gato");
        switch (teclado.nextInt()){
            case 1:
                registro = new PerroTemplate();
                registro.registrar();
                break;
            case 2:
                registro = new GatoTemplate();
                registro.registrar();
                break;
            default:
                System.out.println("Error de ingreso, elija una opcion correcta");
                registrarMascota();
        }
    }
    public void sacarTurno(){

    }
}
