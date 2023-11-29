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

    @OneToMany(mappedBy = "turno", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Perro> perro = new LinkedHashSet<>();

    @OneToMany(mappedBy = "turno", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Gato> gatoes = new LinkedHashSet<>();

    @Column(name = "aprobado")
    private Boolean aprobado;

    @Column(name = "fecha")
    private LocalDate fecha;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "medico_id")
    private Medico medico;

    @Override
    public String toString() {
        return "Turno{" +
                "id=" + id +
                ", perro=" + perro +
                ", gatoes=" + gatoes +
                ", aprobado=" + aprobado +
                ", fecha=" + fecha +
                '}';
    }
}
