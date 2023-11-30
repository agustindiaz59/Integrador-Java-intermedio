package com.utn.sistemadegestionveterinaria.logica;

import com.utn.sistemadegestionveterinaria.logica.medico.MedicoLogica;
import com.utn.sistemadegestionveterinaria.logica.usuario.UsuarioLogica;
import com.utn.sistemadegestionveterinaria.modelos.Medico;

import java.util.Scanner;

public class Inicio {
    private Scanner teclado = new Scanner(System.in);

    public void menu(){
        System.out.println("Bienvenido al programa de gestion veterinaria");
        System.out.println("Desea continuar como medico o como usuario?");
        System.out.println("1 ------ Medico");
        System.out.println("2 ------ Usuario");
        System.out.println("3 ------ Crear medico");
        System.out.println("4 ------ Salir");
        switch (teclado.nextInt()){
            case 1:
                new MedicoLogica().inicio();
                break;
            case 2:
                new UsuarioLogica().usuario(this);
                break;
            case 3:
                new MedicoLogica().registrarMedico();
            case 4:
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
