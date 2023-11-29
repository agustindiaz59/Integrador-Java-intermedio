package com.utn.sistemadegestionveterinaria.logica;

import com.utn.sistemadegestionveterinaria.logica.usuario.UsuarioLogica;

import java.util.Scanner;

public class Inicio {
    private Scanner teclado = new Scanner(System.in);

    public void menu(){
        System.out.println("Bienvenido al programa de gestion veterinaria");
        System.out.println("Desea continuar como medico o como usuario?");
        System.out.println("1 ------ Medico");
        System.out.println("2 ------ Usuario");
        System.out.println("3 ------ Salir");
        switch (teclado.nextInt()){
            case 1:
                medico();
                break;
            case 2:
                new UsuarioLogica().usuario(this);
                break;
            case 3:
                teclado.close();
                System.exit(1);
            default:
                System.out.println();
                System.out.println("Error de ingreso, ingrese una opcion correcta");
                menu();
        }
    }
    public void medico(){

    }

}
