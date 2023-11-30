/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.utn.sistemadegestionveterinaria.modelos;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 *
 * @author matia
 */
@Entity
@Table(name = "turno")
@Getter@Setter
public class Turno implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "gato_id")
    private Gato gato;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "perro_id")
    private Perro perro;

    @Column(name = "aprobado")
    private Boolean aprobado;

    @Column(name = "fecha")
    private String fecha;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "medico_id")
    private Medico medico;

    @Override
    public String toString() {
        return "Turno{" +
                "id = " + id +
                ", perro = " + perro +
                ", gato = " + gato +
                ", aprobado = " + aprobado +
                ", fecha = " + fecha +
                '}';
    }
}
