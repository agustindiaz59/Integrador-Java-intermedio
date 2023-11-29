/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.utn.sistemadegestionveterinaria;

import com.utn.sistemadegestionveterinaria.logica.Inicio;

import java.awt.EventQueue;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author matia
 */
public class SistemaDeGestionVeterinaria {

    public static void main(String[] args) {
        Logger.getLogger("org.hibernate").setLevel(Level.SEVERE); // mensajes de hibernate por consola

        new Inicio().menu();

    }
}
